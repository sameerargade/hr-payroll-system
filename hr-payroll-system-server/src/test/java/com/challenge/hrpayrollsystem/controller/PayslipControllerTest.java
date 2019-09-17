package com.challenge.hrpayrollsystem.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.challenge.hrpayrollsystem.domain.Employee;
import com.challenge.hrpayrollsystem.domain.Payslip;
import com.challenge.hrpayrollsystem.dto.EmployeeDto;
import com.challenge.hrpayrollsystem.dto.IPayslipMapper;
import com.challenge.hrpayrollsystem.dto.PayslipDto;
import com.challenge.hrpayrollsystem.service.PayslipService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PayslipController.class)
public class PayslipControllerTest {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	PayslipService payslipService;
	@MockBean
	IPayslipMapper payslipMapper;
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void createPayslip() throws Exception {
		LocalDate payDate = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setFirstName("john");
		employeeDto.setLastName("smith");
		employeeDto.setAnnualSalary(1200000.0);
		employeeDto.setSuperRate(9.5);
		PayslipDto payslipDto = new PayslipDto();
		payslipDto.setEmployee(employeeDto);
		payslipDto.setPayDate(payDate.toString());
		payslipDto.setPayFrequency("monthly");
		payslipDto.setGrossIncome(10000.0);
		payslipDto.setIncomeTax(2696.0);
		payslipDto.setNetIncome(7304.0);
		payslipDto.setSuperPay(900.0);
		payslipDto.setPay(6404.0);

		Employee employee = new Employee();
		employee.setFirstName("john");
		employee.setLastName("smith");
		Payslip payslip = new Payslip();
		payslip.setEmployee(employee);

		payslip.setPayDate(payDate.toString());
		payslip.setPayFrequency("monthly");
		payslip.setGrossIncome(10000.0);
		payslip.setIncomeTax(2696.0);
		payslip.setNetIncome(7304.0);
		payslip.setSuperPay(900.0);
		payslip.setPay(6404.0);
		when(payslipMapper.asPayslip(payslipDto, payslip)).thenReturn(payslip);
		Optional<Payslip> optionalPayslip = Optional.ofNullable(payslip);
		when(payslipService.savePayslip(payslip)).thenReturn(optionalPayslip);

		mockMvc.perform(MockMvcRequestBuilders.post("/payslips").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}
	
	@Test
	public void checkDuplicatePayslip() throws Exception {
		LocalDate payDate = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setFirstName("john");
		employeeDto.setLastName("smith");
		employeeDto.setAnnualSalary(1200000.0);
		employeeDto.setSuperRate(9.5);
		PayslipDto payslipDto = new PayslipDto();
		payslipDto.setEmployee(employeeDto);
		payslipDto.setPayDate(payDate.toString());
		payslipDto.setPayFrequency("monthly");
		payslipDto.setGrossIncome(10000.0);
		payslipDto.setIncomeTax(2696.0);
		payslipDto.setNetIncome(7304.0);
		payslipDto.setSuperPay(900.0);
		payslipDto.setPay(6404.0);

		Employee employee = new Employee();
		employee.setFirstName("john");
		employee.setLastName("smith");
		Payslip payslip = new Payslip();
		payslip.setEmployee(employee);

		payslip.setPayDate(payDate.toString());
		payslip.setPayFrequency("monthly");
		payslip.setGrossIncome(10000.0);
		payslip.setIncomeTax(2696.0);
		payslip.setNetIncome(7304.0);
		payslip.setSuperPay(900.0);
		payslip.setPay(6404.0);
		when(payslipMapper.asPayslip(payslipDto, payslip)).thenReturn(payslip);
		Optional<Payslip> optionalPayslip = Optional.ofNullable(payslip);
		when(payslipService.savePayslip(payslip)).thenReturn(optionalPayslip);

		mockMvc.perform(MockMvcRequestBuilders.post("/payslips").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

	}
}
