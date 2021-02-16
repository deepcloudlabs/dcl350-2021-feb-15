package com.example.hr.application.business;

import java.util.Optional;

import com.example.hr.application.HrApplication;
import com.example.hr.application.event.EmployeeFiredEvent;
import com.example.hr.application.event.EmployeeHiredEvent;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StandardHrApplication implements HrApplication {
	private EmployeeRepository employeeRepository;
	private EventPublisher eventPublisher;

	public StandardHrApplication(EmployeeRepository employeeRepository, EventPublisher eventPublisher) {
		this.employeeRepository = employeeRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public void hireEmployee(Employee employee) {
		var identity = employee.getIdentity();
		if (employeeRepository.existsByIdentity(identity))
			throw new IllegalArgumentException("Employee already exists!");
		employeeRepository.save(employee);
		eventPublisher.publishEvent(new EmployeeHiredEvent(identity));
	}

	@Override
	public Optional<Employee> fireEmployee(TcKimlikNo identity) {
		var employee = employeeRepository.removeByIdentity(identity);
		if (employee.isPresent())
			eventPublisher.publishEvent(new EmployeeFiredEvent(identity));
		return employee;
	}

}
