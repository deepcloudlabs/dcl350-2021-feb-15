package com.example.hr.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.dto.FireEmployeeResponse;
import com.example.hr.dto.HireEmployeeRequest;
import com.example.hr.dto.HireEmployeeResponse;
import com.example.hr.service.HrService;

@Service
public class SimpleHrService implements HrService{
	@Autowired
	private HrApplication hrApplication;
	
	// DDD -> ACL (Anti-corruption Layer)
	@Override
	public HireEmployeeResponse hire(HireEmployeeRequest request) {
		Employee employee = request.toEmployee();
		hrApplication.hireEmployee(employee);
		return new HireEmployeeResponse("success");
	}

	@Override
	public FireEmployeeResponse fire(String identity) {
		TcKimlikNo tcKimlikNo = TcKimlikNo.valueOf(identity);
		var firedEmployee = hrApplication.fireEmployee(tcKimlikNo);
		String status = "success";
		if (firedEmployee.isEmpty())
			status = "fail";
		return new FireEmployeeResponse(status);
	}

}
