package com.challenge.hrpayrollsystem.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.challenge.hrpayrollsystem.domain.Payslip;
import com.challenge.hrpayrollsystem.exceptions.DuplicatePayException;
import com.challenge.hrpayrollsystem.service.PayslipService;
@Controller
public class PayslipController {

	@Autowired
	PayslipService payslipService;

	@RequestMapping(value = "/savePayslip", method = RequestMethod.POST)
	public ResponseEntity createPost(Payslip payslip) {
		Optional<Payslip> optionalPayslip = Optional.ofNullable(null);
		try {
			optionalPayslip = payslipService.savePayslip(payslip);

			return new ResponseEntity(optionalPayslip, HttpStatus.OK);
		} catch (DuplicatePayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(optionalPayslip, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
