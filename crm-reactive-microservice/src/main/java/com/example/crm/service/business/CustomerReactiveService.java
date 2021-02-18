package com.example.crm.service.business;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.crm.domain.Customer;
import com.example.crm.event.CustomerCreatedEvent;
import com.example.crm.repository.CustomerRepository;
import com.example.crm.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerReactiveService implements CustomerService {
	private CustomerRepository customerRepository;
	private ApplicationEventPublisher applicationEventPublisher;
	
	public CustomerReactiveService(CustomerRepository customerRepository,
			ApplicationEventPublisher applicationEventPublisher) {
		this.customerRepository = customerRepository;
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@Override
	public Mono<Customer> findCustomerByIdentity(String identity) {
		return customerRepository.findById(identity);
	}

	@Override
	public Flux<Customer> findCustomersByPage(int page, int size) {
		return customerRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public void addCustomer(Customer customer) {
		
		var customerCreatedEvent = new CustomerCreatedEvent(customer.getIdentity(),customer.getEmail());
		applicationEventPublisher.publishEvent(customerCreatedEvent);
	}

}
