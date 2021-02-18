package com.example.hr.dto;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.validation.Iban;
import com.example.validation.TcKimlik;

public class HireEmployeeRequest {
	@TcKimlik
	private String identity;
	@NotEmpty
	@Pattern(regexp = "^[A-Z][a-z]+$")
	private String firstName;
	@NotEmpty
	@Pattern(regexp = "^[A-Z][a-z]+$")
	private String lastName;
	@Iban
	private String iban;
	@Min(5000)
	private double salary;
	@Pattern(regexp = "^[A-Z]{2,}$")
	private String currencySymbol;
	private String photo;
	@Max(2010)
	private int birthYear;
	private boolean fulltime;
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

	public boolean isFulltime() {
		return fulltime;
	}

	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
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
