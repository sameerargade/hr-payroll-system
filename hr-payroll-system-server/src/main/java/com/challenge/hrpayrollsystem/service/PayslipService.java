package com.challenge.hrpayrollsystem.service;

import java.util.Optional;

import com.challenge.hrpayrollsystem.domain.Employee;
import com.challenge.hrpayrollsystem.domain.Payslip;
import com.challenge.hrpayrollsystem.exceptions.DuplicatePayException;

public interface PayslipService {
	Optional<Payslip> savePayslip(Payslip payslip) throws DuplicatePayException;
	Boolean doesExist(Employee employee,String payDate);
}
