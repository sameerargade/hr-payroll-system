package com.challenge.hrpayrollsystem.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PayslipRepository extends JpaRepository<Payslip, Long> {
	
	Optional<Payslip> findByEmployee_IdAndPayDate(Integer employeeID, String payDate);

}
