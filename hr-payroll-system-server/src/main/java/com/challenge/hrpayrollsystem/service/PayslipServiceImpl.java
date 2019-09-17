package com.challenge.hrpayrollsystem.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.challenge.hrpayrollsystem.domain.Employee;
import com.challenge.hrpayrollsystem.domain.EmployeeRepository;
import com.challenge.hrpayrollsystem.domain.Payslip;
import com.challenge.hrpayrollsystem.domain.PayslipRepository;
import com.challenge.hrpayrollsystem.exceptions.DuplicatePayException;
@Service
public class PayslipServiceImpl implements PayslipService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	EmployeeRepository employeeRepository;
	
	PayslipRepository payslipRepository;
	
	public PayslipServiceImpl(EmployeeRepository employeeRepository,PayslipRepository payslipRepository){
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
			payslip.setCreatedBy("system");
			payslip = payslipRepository.save(payslip);
			optionalPayslip = Optional.ofNullable(payslip);
		}catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			logger.debug("Duplicate Payslip for employee: " + employee.getFirstName() + " " +  employee.getLastName());
			logger.error("Duplicate Payslip", e);
			throw new DuplicatePayException("Duplicate Payslip");
		}
	
		return optionalPayslip;
	}

	@Override
	public Boolean doesExist(Employee employee, String payDate) {
		// TODO Auto-generated method stub
		return false;
	}

}
