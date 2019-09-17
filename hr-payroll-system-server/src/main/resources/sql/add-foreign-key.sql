ALTER TABLE `hrpayrollsystem`.`payslip` 
ADD INDEX `fk_payslip_emloyee_idx` (`employeeID` ASC);
;
ALTER TABLE `hrpayrollsystem`.`payslip` 
ADD CONSTRAINT `fk_payslip_emloyee`
  FOREIGN KEY (`employeeID`)
  REFERENCES `hrpayrollsystem`.`employee` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;