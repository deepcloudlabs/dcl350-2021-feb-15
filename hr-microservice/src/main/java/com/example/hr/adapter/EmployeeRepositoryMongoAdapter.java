package com.example.hr.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.repository.EmployeeMongoRepository;
import com.example.hr.repository.EmployeeRepository;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Repository
@ConditionalOnProperty(value = "database.type", havingValue = "mongodb")
public class EmployeeRepositoryMongoAdapter implements EmployeeRepository {
	@Autowired
	private EmployeeMongoRepository empMongoRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Optional<Employee> findByIdentity(TcKimlikNo identity) {
		Optional<EmployeeDocument> empDoc = empMongoRepo.findById(identity.getValue());
		if (empDoc.isPresent())
			return Optional.of(mapper.map(empDoc.get(),Employee.class));
		return Optional.empty();
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> removeByIdentity(TcKimlikNo identity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsByIdentity(TcKimlikNo identity) {
		// TODO Auto-generated method stub
		return false;
	}

}
