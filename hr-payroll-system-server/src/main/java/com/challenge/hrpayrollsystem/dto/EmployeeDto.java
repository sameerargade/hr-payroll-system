package com.challenge.hrpayrollsystem.dto;

public class EmployeeDto {
	private String firstName;
	private String lastName;
	private Double annualSalary;
	private Double superRate;
	
	
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
