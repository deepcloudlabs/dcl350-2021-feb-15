package com.example.hr.adapter;

import org.springframework.stereotype.Service;

import com.example.hr.infrastructure.EventPublisher;

@Service
public class EventPublisherKafkaAdapter implements EventPublisher {

	@Override
	public void publishEvent(Object event) {
		// TODO Auto-generated method stub

	}

}
