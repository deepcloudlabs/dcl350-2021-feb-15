package com.example.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	private AtomicInteger counter = new AtomicInteger(0);

	@Scheduled(fixedRate = 1_000)
	public void produceMessage() {
		rabbitTemplate.convertAndSend("exkurt", null, "Hello Mars " + counter.incrementAndGet());
	}

}
