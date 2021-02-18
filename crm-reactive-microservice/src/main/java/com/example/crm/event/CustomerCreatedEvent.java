package com.example.crm.event;

public class CustomerCreatedEvent {

	private final String identity;
	private final String email;

	public CustomerCreatedEvent(String identity, String email) {
		this.identity = identity;
		this.email = email;
	}

	public String getIdentity() {
		return identity;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "CustomerCreatedEvent [identity=" + identity + ", email=" + email + "]";
	}

}
