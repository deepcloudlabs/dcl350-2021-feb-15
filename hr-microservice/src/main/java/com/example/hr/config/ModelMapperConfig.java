package com.example.hr.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.EmploymentType;
import com.example.hr.domain.FiatCurrency;
import com.example.hr.domain.FullName;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.dto.HireEmployeeRequest;
import com.example.hr.orm.EmployeeEntity;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Configuration
public class ModelMapperConfig {
	private static final Converter<EmployeeDocument, Employee> employeeDocumentToEmployeeConverter = context -> {
		var employeeDocument = context.getSource();
		String[] tokens = employeeDocument.getFullname().split("\\w+");
		return new Employee.Builder(TcKimlikNo.valueOf(employeeDocument.getIdentity()))
				.fullname(tokens[0], tokens[1])
				.iban(employeeDocument.getIban())
				.salary(employeeDocument.getSalary(), FiatCurrency.valueOf("TL"))
				.birthYear(employeeDocument.getBirthYear())
				.employementType(employeeDocument.getFulltime()? EmploymentType.FULL_TIME : EmploymentType.PART_TIME)
				.departments(employeeDocument.getDepartments().toArray(new Department[0]))
				.photo(employeeDocument.getPhoto().getBytes())
				.build();
	};
	
	private static final Converter<Employee, EmployeeDocument> employeeToEmployeeDocumentConverter = (context -> {
		var employee = context.getSource();
		EmployeeDocument employeeDocument = new EmployeeDocument();
		employeeDocument.setIdentity(employee.getIdentity().getValue());
		FullName fullname = employee.getFullname();
		employeeDocument.setFullname(fullname.getFirst() + " " + fullname.getLast());
		employeeDocument.setSalary(employee.getSalary().getValue());
		employeeDocument.setIban(employee.getIban().getValue());
		employeeDocument.setPhoto(new String(employee.getPhoto().getValues()));
		employeeDocument.setBirthYear(employee.getBirthYear().getValue());
		employeeDocument.setDepartments(employee.getDepartments());
		employeeDocument.setFulltime(employee.getEmployementType()==EmploymentType.FULL_TIME);
		return employeeDocument;
	});
	
	private static final Converter<HireEmployeeRequest, Employee> employeeRequestToEmployeeConverter = (context -> {
		var employeeRequest = context.getSource();
		return new Employee.Builder(TcKimlikNo.valueOf(employeeRequest.getIdentity()))
				.fullname(employeeRequest.getFirstName(), employeeRequest.getLastName())
				.iban(employeeRequest.getIban())
				.salary(employeeRequest.getSalary(), FiatCurrency.valueOf("TL"))
				.birthYear(employeeRequest.getBirthYear())
				.employementType(employeeRequest.isFulltime() ? EmploymentType.FULL_TIME : EmploymentType.PART_TIME)
				.departments(employeeRequest.getDepartments().toArray(new Department[0]))
				.photo(employeeRequest.getPhoto().getBytes()).build();
	});
	
	private static final Converter<EmployeeEntity, Employee> employeeEntityToEmployeeConverter = (context -> {
		var employeeEntity = context.getSource();
		String[] tokens = employeeEntity.getFullname().split("\\s+");
		return new Employee.Builder(TcKimlikNo.valueOf(employeeEntity.getIdentity()))
				.fullname(tokens[0], tokens[1])
				.iban(employeeEntity.getIban())
				.salary(employeeEntity.getSalary(), FiatCurrency.valueOf("TL"))
				.birthYear(employeeEntity.getBirthYear())
				.employementType(employeeEntity.isFulltime() ? EmploymentType.FULL_TIME : EmploymentType.PART_TIME)
				.departments(employeeEntity.getDepartments().toArray(new Department[0]))
				.photo(employeeEntity.getPhoto())
				.build();
	});
	
	private static final Converter<Employee, EmployeeEntity> employeeToEmployeeEntityConverter = context -> {
		var employee = context.getSource();
		EmployeeEntity entity = new EmployeeEntity();
		entity.setIdentity(employee.getIdentity().getValue());
		FullName fullname = employee.getFullname();
		entity.setFullname(fullname.getFirst() + " " + fullname.getLast());
		entity.setSalary(employee.getSalary().getValue());
		entity.setIban(employee.getIban().getValue());
		entity.setBirthYear(employee.getBirthYear().getValue());
		entity.setDepartments(employee.getDepartments());
		entity.setPhoto(employee.getPhoto().getValues());
		entity.setFulltime(employee.getEmployementType() == EmploymentType.FULL_TIME);
		return entity;
	};
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.addConverter(employeeRequestToEmployeeConverter, HireEmployeeRequest.class, Employee.class);
		mapper.addConverter(employeeEntityToEmployeeConverter, EmployeeEntity.class, Employee.class);
		mapper.addConverter(employeeToEmployeeDocumentConverter, Employee.class, EmployeeDocument.class);
		mapper.addConverter(employeeDocumentToEmployeeConverter, EmployeeDocument.class, Employee.class);
		mapper.addConverter(employeeToEmployeeEntityConverter, Employee.class, EmployeeEntity.class);
		return mapper;
	}
}
