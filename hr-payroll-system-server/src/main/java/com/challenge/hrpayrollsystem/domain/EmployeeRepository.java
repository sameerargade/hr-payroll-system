package com.challenge.hrpayrollsystem.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByFirstNameAndLastName(String firstName, String lastName);

}
