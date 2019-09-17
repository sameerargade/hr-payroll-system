package com.challenge.hrpayrollsystem.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.challenge.hrpayrollsystem.domain.Payslip;
import com.challenge.hrpayrollsystem.dto.IPayslipMapper;
import com.challenge.hrpayrollsystem.dto.PayslipDto;
import com.challenge.hrpayrollsystem.exceptions.DuplicatePayException;
import com.challenge.hrpayrollsystem.service.PayslipService;
@Controller
public class PayslipController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@Autowired
	PayslipService payslipService;
	//@Autowired
	IPayslipMapper payslipMapper;
	
	public PayslipController(PayslipService payslipService,IPayslipMapper payslipMapper) {
		this.payslipService = payslipService;
		this.payslipMapper = payslipMapper;
	}

	@RequestMapping(value = "/payslips", method = RequestMethod.POST)
	public ResponseEntity savePayslip(@RequestBody PayslipDto payslipDto) throws DuplicatePayException {
		Optional<Payslip> optionalPayslip = Optional.ofNullable(null);
		Payslip payslip = new Payslip();
			payslip = payslipMapper.asPayslip(payslipDto, payslip);
			optionalPayslip = payslipService.savePayslip(payslip);
			return new ResponseEntity(optionalPayslip, HttpStatus.OK);

	}

}
