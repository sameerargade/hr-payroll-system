package com.challenge.hrpayrollsystem.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.challenge.hrpayrollsystem.domain.Employee;
import com.challenge.hrpayrollsystem.domain.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeServiceImpl(EmployeeRepository employeeRepository){
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
