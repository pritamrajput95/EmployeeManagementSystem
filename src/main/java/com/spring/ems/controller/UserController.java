package com.spring.ems.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	private static Logger log=Logger.getLogger(UserController.class);

	
	@RequestMapping("/index")
	public String home(Model model) {
		log.info("User controller called....");
		return "user/user_dashboard";
	}

	
}
