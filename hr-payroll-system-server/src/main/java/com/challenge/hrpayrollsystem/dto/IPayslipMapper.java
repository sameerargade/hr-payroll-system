package com.challenge.hrpayrollsystem.dto;

import com.challenge.hrpayrollsystem.domain.Payslip;

import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface IPayslipMapper {
	public Payslip asPayslip ( PayslipDto in, Payslip out);
	    
}
