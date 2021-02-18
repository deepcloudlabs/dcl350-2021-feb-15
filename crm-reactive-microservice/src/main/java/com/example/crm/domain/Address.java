package com.example.crm.domain;

import org.springframework.data.mongodb.core.mapping.Field;

public class Address {
	private String country;
	private String city;
	private String line;
	@Field("zip_code")
	private String zipCode;
	private AddressType type;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Address [country=" + country + ", city=" + city + ", line=" + line + ", zipCode=" + zipCode + ", type="
				+ type + "]";
	}

}
