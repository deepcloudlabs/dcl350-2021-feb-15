package com.example.hr.application.event;

import com.example.hr.domain.TcKimlikNo;

public class EmployeeFiredEvent {
	private TcKimlikNo identity;

	public EmployeeFiredEvent(TcKimlikNo identity) {
		this.identity = identity;
	}

	public TcKimlikNo getIdentity() {
		return identity;
	}
}
