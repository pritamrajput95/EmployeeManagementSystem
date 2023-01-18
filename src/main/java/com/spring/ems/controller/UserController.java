package com.spring.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	
	
	@RequestMapping("/index")
	public String home(Model model) {
		
		return "user/user_dashboard";
	}

	
}
