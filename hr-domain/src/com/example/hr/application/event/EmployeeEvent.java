package com.example.hr.application.event;

import com.example.hr.domain.TcKimlikNo;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public abstract class EmployeeEvent {
	private TcKimlikNo identity;

	public EmployeeEvent(TcKimlikNo identity) {
		this.identity = identity;
	}

	public TcKimlikNo getIdentity() {
		return identity;
	}
}
