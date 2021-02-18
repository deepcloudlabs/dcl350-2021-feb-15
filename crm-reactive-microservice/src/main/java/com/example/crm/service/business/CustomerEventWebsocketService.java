package com.example.crm.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.crm.event.CustomerCreatedEvent;

@Service
public class CustomerEventWebsocketService {
	@Autowired
	private SimpMessagingTemplate msgTemplate;
	
	@EventListener
	public void listenCustomerEvent(CustomerCreatedEvent event) {
		msgTemplate.convertAndSend("/changes", event); // multicast
		msgTemplate.convertAndSendToUser("jack", "/changes", event); // unicast/p2p
	}
}
