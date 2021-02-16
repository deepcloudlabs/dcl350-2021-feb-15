package com.example.hr.infrastructure;

import com.example.hr.application.event.EmployeeEvent;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public interface EventPublisher {
	void publishEvent(EmployeeEvent event);
}
