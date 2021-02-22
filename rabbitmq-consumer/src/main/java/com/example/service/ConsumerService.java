package com.example.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	@RabbitListener(queues = "qkurt")
	public void handleMessage(@Payload String msg) {
		System.err.println(msg);
//		throw new IllegalArgumentException();
	}
}
