package com.example.hr.domain;

import java.util.Arrays;
import java.util.List;

import com.example.ddd.Aggregate;
import com.example.ddd.Identity;

// Entity -> Persistent -> i. has an identity, ii. mutable  
// Entity Root -> Aggregate -> Bounded Context
// Entity -> Builder (Effective Java 3rd)
@Aggregate
public class Employee {
	@Identity
	private TcKimlikNo identity;
	private FullName fullname;
	private Iban iban;
	private Money salary;
	private BirthYear birthYear;
	private Photo photo;
	private List<Department> departments;

	public Employee(TcKimlikNo identity, FullName fullname) {
		this.identity = identity;
		this.fullname = fullname;
	}

	public Employee(TcKimlikNo identity, FullName fullname, BirthYear birthYear) {
		this.identity = identity;
		this.fullname = fullname;
		this.birthYear = birthYear;
	}

	public Employee(TcKimlikNo identity, FullName fullname, BirthYear birthYear, Iban iban, Money salary) {
		this.identity = identity;
		this.fullname = fullname;
		this.iban = iban;
		this.salary = salary;
		this.birthYear = birthYear;
	}

	public Employee(Builder builder) {
		this(builder.identity,builder.fullname,builder.birthYear);
		setDepartments(builder.departments);
		setPhoto(builder.photo);
		setIban(builder.iban);
		setSalary(builder.salary);
	}

	public TcKimlikNo getIdentity() {
		return identity;
	}

	public void setIdentity(TcKimlikNo identity) {
		this.identity = identity;
	}

	public FullName getFullname() {
		return fullname;
	}

	public void setFullname(FullName fullname) {
		this.fullname = fullname;
	}

	public Iban getIban() {
		return iban;
	}

	public void setIban(Iban iban) {
		this.iban = iban;
	}

	public Money getSalary() {
		return salary;
	}

	public void setSalary(Money salary) {
		this.salary = salary;
	}

	public BirthYear getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(BirthYear birthYear) {
		this.birthYear = birthYear;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public static class Builder {
		private TcKimlikNo identity;
		private FullName fullname;
		private Iban iban;
		private Money salary;
		private BirthYear birthYear;
		private Photo photo;
		private List<Department> departments;
		
		public Builder(TcKimlikNo identity) {
			this.identity = identity;
		}
		
		public Builder fullname(String first, String last) {
			this.fullname = new FullName(first,last);
			return this;
		}
		
		public Builder iban(String value) {
			this.iban = Iban.valueOf(value);
			return this;
		}
		
		public Builder salary(double value, FiatCurrency fiatCurrency) {
			this.salary = Money.valueOf(value, fiatCurrency);
			return this;
		}
		
		public Builder birthYear(int value) {
			this.birthYear = BirthYear.valueOf(value);
			return this;
		}
		
		public Builder photo(byte[] values) {
			this.photo = Photo.valueOf(values);
			return this;
		}
		
		public Builder departments(Department... departments) {
			this.departments = Arrays.asList(departments);
			return this;
		}
		
		public Employee build() {
			// validation
			return new Employee(this);
		}
	}
}
