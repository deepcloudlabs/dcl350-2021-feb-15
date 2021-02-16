package com.example.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.hr.dto.FireEmployeeResponse;
import com.example.hr.dto.HireEmployeeRequest;
import com.example.hr.dto.HireEmployeeResponse;
import com.example.hr.service.HrService;

// Adapter -> HTTP Protocol -> Java Class
@RestController
@RequestScope
@RequestMapping("commands")
@CrossOrigin
public class HrRestController {
	@Autowired
	private HrService hrService;

	@PostMapping
	public HireEmployeeResponse hire(HireEmployeeRequest request) {
		return hrService.hire(request);
	}

	@DeleteMapping("{identity}")
	public FireEmployeeResponse fire(@PathVariable String identity) {
		return hrService.fire(identity);
	}
}
