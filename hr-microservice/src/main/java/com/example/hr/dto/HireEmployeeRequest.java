package com.example.hr.dto;

import java.util.List;

import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;

public class HireEmployeeRequest {
	private String identity;
	private String firstName;
	private String lastName;
	private String iban;
	private double salary;
	private String currencySymbol;
	private String photo;
	private int birthYear;
	private List<Department> departments;

	public HireEmployeeRequest() {
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "HireEmployeeRequest [identity=" + identity + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", iban=" + iban + ", salary=" + salary + ", currencySymbol=" + currencySymbol + ", birthYear="
				+ birthYear + ", departments=" + departments + "]";
	}

	public Employee toEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}
