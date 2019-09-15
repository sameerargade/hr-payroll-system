package com.challenge.hrpayrollsystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	Long id;
	@Column(name = "first_name", nullable = false)
	String firstName;
	@Column(name = "last_name", nullable = false)
	String lastName;
	Double annualSalary;
	public Double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(Double annualSalary) {
		this.annualSalary = annualSalary;
	}

	public Double getSuperRate() {
		return superRate;
	}

	public void setSuperRate(Double superRate) {
		this.superRate = superRate;
	}

	Double superRate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
