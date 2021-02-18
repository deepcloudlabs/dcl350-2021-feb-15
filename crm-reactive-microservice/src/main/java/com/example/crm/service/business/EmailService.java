package com.example.crm.service.business;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.crm.event.CustomerCreatedEvent;

@Service
public class EmailService {
	@EventListener
	public void listenEvents(CustomerCreatedEvent event) {
		System.err.println("Sending e-mail to "+event.getEmail());
	}
}
