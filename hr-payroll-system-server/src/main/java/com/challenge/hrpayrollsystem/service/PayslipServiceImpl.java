package com.challenge.hrpayrollsystem.service;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Service;

import com.challenge.hrpayrollsystem.domain.Employee;
import com.challenge.hrpayrollsystem.domain.EmployeeRepository;
import com.challenge.hrpayrollsystem.domain.Payslip;
import com.challenge.hrpayrollsystem.domain.PayslipRepository;
import com.challenge.hrpayrollsystem.exceptions.DuplicatePayException;
@Service
public class PayslipServiceImpl implements PayslipService {
	
	EmployeeRepository employeeRepository;
	
	PayslipRepository payslipRepository;
	
	PayslipServiceImpl(EmployeeRepository employeeRepository,PayslipRepository payslipRepository){
		this.employeeRepository = employeeRepository;
		this.payslipRepository = payslipRepository;
	}

	@Override
	public Optional<Payslip> savePayslip(Payslip payslip) throws DuplicatePayException{
		Employee employee = null; 
		Optional<Payslip> optionalPayslip = Optional.ofNullable(null);
		try {
			employee = employeeRepository.save(payslip.getEmployee());
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
			employee = employeeRepository.findByFirstNameAndLastName(payslip.getEmployee().getFirstName(), payslip.getEmployee().getLastName());
			
		}
		payslip.setEmployee(employee);
		try {
			
			payslip = payslipRepository.save(payslip);
			optionalPayslip = Optional.ofNullable(payslip);
		}catch(ConstraintViolationException e) {
			e.printStackTrace();
			throw new DuplicatePayException();
		}
	
		return optionalPayslip;
	}

	@Override
	public Boolean doesExist(Employee employee, String payDate) {
		// TODO Auto-generated method stub
		return false;
	}

}
