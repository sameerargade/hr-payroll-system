package com.challenge.hrpayrollsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HrPayrollSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollSystemApplication.class, args);
	}

}
