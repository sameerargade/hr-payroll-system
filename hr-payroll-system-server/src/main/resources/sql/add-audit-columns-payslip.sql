ALTER TABLE `hrpayrollsystem`.`payslip` 
ADD COLUMN `date_created` TIMESTAMP NOT NULL AFTER `pay`,
ADD COLUMN `created_by` VARCHAR(45) NOT NULL DEFAULT 'system' AFTER `date_created`;
