package com.example.hr.application.event;

import com.example.hr.domain.TcKimlikNo;

public class EmployeeHiredEvent {

	private TcKimlikNo identity;

	public EmployeeHiredEvent(TcKimlikNo identity) {
		this.identity = identity;
	}

	public TcKimlikNo getIdentity() {
		return identity;
	}

}
