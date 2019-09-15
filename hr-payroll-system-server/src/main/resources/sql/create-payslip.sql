CREATE TABLE `hrpayrollsystem`.`payslip` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `employeeID` INT NOT NULL,
  `pay_date` VARCHAR(45) NOT NULL,
  `pay_frequency` VARCHAR(45) NOT NULL,
  `gross_income` DOUBLE NOT NULL,
  `income_tax` DOUBLE NOT NULL,
  `net_income` DOUBLE NOT NULL,
  `super` DOUBLE NOT NULL,
  `pay` DOUBLE NOT NULL,
  PRIMARY KEY (`id`));