package com.spring.ems;


import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.spring.ems.logger.GlobalLogger;



@SpringBootApplication
public class EmployeeManagementSystemApplication {
   
	private static Logger logger=GlobalLogger.getLogger(EmployeeManagementSystemApplication.class);   
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
		System.out.println("Main App");
		
		logger.info("<======= main application running =======>");		

	}

}
