# hr-payroll-system

Repository for HR Payroll System

This project uses Angular 8 for the frontend with angular material, ngx-alerts third-party libraries, bootstrap for css.

It uses spring boot 2.0.6 release and swagger2 for API documentation and as test harness on the serverside.

The project has 2 pages one to accept employee information and second page to display the generated payslip. It also has a button to generate pay, to save the payslip in the mysql database. If clicked twice you get error message at the frontend and a duplicatepayecxeption is thrown on the server side. 
The swagger ui can be used to retrieve all saved payslips to audit.

The whole project is packaged into a single jar named hr-payroll-system-server-0.0.1.jar and is run as a single jar file with an embeded tomcat running on port 8081 and context path /
It automatically redirects to the employee-info page. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

java (JDK 8.0 and above)
maven 3.6
Make sure JAVA_HOME and MVN_HOME are pointing to the correct locations.
mysql 5.7
clone the code to your local directory
you will get one parent project named hr-payroll-system and 2 module projects.
hr-payroll-system-server
hr-payroll-system-web
a pom.xml for the parent project and this readme.md file.

### Installing

1.Set up database.

	Login to mysql with a user who has permissions to create new users

	Run the following scripts in the given order from the folder hr-payroll-system-server->src->main->rsources->sql

		1.create-user.sql
		2.createschema.sql
		3.create-employee.sql
		4.employee-unique-key.sql
		5.create-payslip.sql
		6.payslip-unique-key.sql
		7.add-foreign-key.sql
		8.add-audit-columns-payslip.sql
2.Package Jar.

		1. Go to the parent project directory and run mvn clean package.(This creates the jar hr-payroll-system-server-0.0.1.jar inside the target folder of the server-project) (this takes some time when run for the first time)
		2. run-> java -jar /hr-payroll-system-server/target/hr-payroll-system-server-0.0.1.jar to run the project on port 8081. so hitting http://localhost:8081/ will bring up the home page
		3. The test harness to test the api is present at the following location http://localhost:8081/swagger-ui.html#/
		4. The log can be found in the server root directory with the name hrpayrollsystem.log, it rolls over once it crosses 1MB in size and is compressed to save the disk space. 
	
## Running the tests

	1. to run the frontend tests run ng test from the /hr-payroll-system-web/src/app directory.
	2. The server side tests run at the time of packaging itself.
	

	