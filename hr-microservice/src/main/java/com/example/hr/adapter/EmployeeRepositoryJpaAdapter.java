package com.example.hr.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.orm.EmployeeEntity;
import com.example.hr.repository.EmployeeJpaRepository;
import com.example.hr.repository.EmployeeRepository;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Repository
@ConditionalOnProperty(value = "database.type", havingValue = "relational")
public class EmployeeRepositoryJpaAdapter implements EmployeeRepository {
	@Autowired
	private EmployeeJpaRepository empJpaRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public Optional<Employee> findByIdentity(TcKimlikNo identity) {
		var emp = empJpaRepo.findById(identity.getValue());
		if (emp.isPresent()) { 
			return Optional.of(mapper.map(emp.get(), Employee.class));
		}
		return Optional.empty();
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		empJpaRepo.save(mapper.map(employee, EmployeeEntity.class));
		return employee;
	}

	@Override
	public boolean existsByIdentity(TcKimlikNo identity) {
		return empJpaRepo.findById(identity.getValue()).isPresent();
	}

	@Override
	public Optional<Employee> removeByIdentity(TcKimlikNo identity) {
		var optEmployee = empJpaRepo.findById(identity.getValue());
		if (optEmployee.isEmpty()) {
			return Optional.empty();
		}
		var employeeEntity = optEmployee.get();
		empJpaRepo.delete(employeeEntity);
		return Optional.of(mapper.map(employeeEntity, Employee.class));
	}

}
