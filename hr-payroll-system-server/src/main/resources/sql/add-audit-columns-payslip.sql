ALTER TABLE `hrpayrollsystem`.`payslip` 
ADD COLUMN `created_at` TIMESTAMP NOT NULL AFTER `pay`,
ADD COLUMN `created_by` VARCHAR(45) NOT NULL DEFAULT 'system' AFTER `date_created`;
