package com.spring.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		return "admin/admin_dashboard";
	}

	
}
