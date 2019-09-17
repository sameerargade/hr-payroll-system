package com.challenge.hrpayrollsystem.service;

import java.util.List;
import java.util.Optional;

import com.challenge.hrpayrollsystem.domain.Payslip;
import com.challenge.hrpayrollsystem.exceptions.DuplicatePayException;

public interface PayslipService {
	Optional<Payslip> savePayslip(Payslip payslip) throws DuplicatePayException;
	List<Payslip> retrievePayslips();
}
