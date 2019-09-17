 	
CREATE USER 'hrpayrollsystem'@'localhost' IDENTIFIED BY 'r@nd0m5+r!n9';
commit;
GRANT CREATE,SELECT, INSERT, DELETE ON database.* TO 'user'@'localhost';
commit;
 	
FLUSH PRIVILEGES;