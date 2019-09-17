package com.challenge.hrpayrollsystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Payslip Management System", description = "Operations pertaining to Payslip ")
@Controller
public class PayslipController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// @Autowired
	PayslipService payslipService;
	// @Autowired
	IPayslipMapper payslipMapper;

	public PayslipController(PayslipService payslipService, IPayslipMapper payslipMapper) {
		this.payslipService = payslipService;
		this.payslipMapper = payslipMapper;
	}

	@ApiOperation(value = "Save payslip", response = Payslip.class)

	@ApiResponses(value = {

			@ApiResponse(code = 200, message = "Successfully saved payslip"),

			
			@ApiResponse(code = 400, message = "Duplicate pay exception")

	})
	@RequestMapping(value = "/payslips", method = RequestMethod.POST)
	public ResponseEntity savePayslip(@ApiParam(value = "Payslip", required = true)@Valid @RequestBody PayslipDto payslipDto) throws DuplicatePayException {
		Optional<Payslip> optionalPayslip = Optional.ofNullable(null);
		Payslip payslip = new Payslip();
		payslip = payslipMapper.asPayslip(payslipDto, payslip);
		optionalPayslip = payslipService.savePayslip(payslip);
		return new ResponseEntity(optionalPayslip, HttpStatus.OK);

	}

	@ApiOperation(value = "View a list of available payslips", response = List.class)

	@ApiResponses(value = {

			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")

	})

	@RequestMapping(value = "/payslips", method = RequestMethod.GET)
	public ResponseEntity getPayslips() {

		List<Payslip> payslips = payslipService.retrievePayslips();
		return new ResponseEntity(payslips, HttpStatus.OK);

	}

}
