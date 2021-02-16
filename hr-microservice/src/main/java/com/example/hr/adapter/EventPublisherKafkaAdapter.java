package com.example.hr.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.hr.application.event.EmployeeEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Service
public class EventPublisherKafkaAdapter implements EventPublisher {
	private final Logger logger = LoggerFactory.getLogger(EventPublisherKafkaAdapter.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private ObjectMapper mapper;

	@Override
	public void publishEvent(EmployeeEvent event) {
		try {
			var json = mapper.writeValueAsString(event);
			kafkaTemplate.send("hr", json);
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage());
		}
	}

}
