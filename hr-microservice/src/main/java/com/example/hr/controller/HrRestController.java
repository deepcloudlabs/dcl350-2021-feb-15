package com.example.hr.controller;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.hr.dto.ErrorResponse;
import com.example.hr.dto.FireEmployeeResponse;
import com.example.hr.dto.HireEmployeeRequest;
import com.example.hr.dto.HireEmployeeResponse;
import com.example.hr.service.HrService;
import com.example.validation.TcKimlik;

// Adapter -> HTTP Protocol -> Java Class
@RestController
@RequestScope
@RequestMapping("commands")
@CrossOrigin
@Validated
public class HrRestController {
	@Autowired
	private HrService hrService;

	@PostMapping
	public HireEmployeeResponse hire(@RequestBody @Validated HireEmployeeRequest request) {
		return hrService.hire(request);
	}

	@DeleteMapping("{identity}")
	public FireEmployeeResponse fire(@PathVariable @Validated @TcKimlik String identity) {
		return hrService.fire(identity);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleConstraintViolationException(ConstraintViolationException e) {
		var violations = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.joining("|"));
		return new ErrorResponse("validation violation", violations);
	}
}
