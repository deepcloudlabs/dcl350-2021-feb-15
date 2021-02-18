package com.example.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

// wss://localhost:9900/lottery/api/v1/topic/changes
// http://localhost:9900/lottery/api/v1/topic/changes
@SpringBootApplication
public class CrmReactiveMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmReactiveMicroserviceApplication.class, args);
	}

}
