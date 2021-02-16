package com.example.hr.service;

import com.example.hr.dto.FireEmployeeResponse;
import com.example.hr.dto.HireEmployeeRequest;
import com.example.hr.dto.HireEmployeeResponse;

public interface HrService {

	HireEmployeeResponse hire(HireEmployeeRequest request);

	FireEmployeeResponse fire(String identity);

}
