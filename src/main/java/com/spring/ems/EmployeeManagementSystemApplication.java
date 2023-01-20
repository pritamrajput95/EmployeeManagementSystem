package com.spring.ems;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EmployeeManagementSystemApplication {
   
	private static final Logger LOGGER = Logger.getLogger(EmployeeManagementSystemApplication.class);
    
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
		System.out.println("Main App");
		
		LOGGER.info("main application run *******");
		LOGGER.debug("debugge");

	}

}
