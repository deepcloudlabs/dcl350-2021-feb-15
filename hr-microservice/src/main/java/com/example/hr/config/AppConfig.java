package com.example.hr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.application.HrApplication;
import com.example.hr.application.business.StandardHrApplication;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

@Configuration
public class AppConfig {

	@Bean
	public HrApplication createHrApplication(
			EmployeeRepository employeeRepository, // -> Adapter
			EventPublisher eventPublisher // -> Adapter
			) {
		return new StandardHrApplication(employeeRepository, eventPublisher);
	}
}
