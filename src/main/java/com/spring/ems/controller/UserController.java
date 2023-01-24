package com.spring.ems.controller;


import java.security.Principal;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ems.beans.User;
import com.spring.ems.logger.GlobalLogger;
import com.spring.ems.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

   private static Logger logger = GlobalLogger.getLogger(UserController.class);

   @Autowired
    UserRepository userRepo;
	
	@RequestMapping("/index")
	public String dashboard(Model model,Principal principal) {
	    logger.info("+++++ index page called +++++++");
	    logger.info("+++++ user dashboard is calling +++++++");
	    
	    String userName=principal.getName();
	    logger.info("+++++++username=======>"+userName);
	    
	    
	    User user=userRepo.getUserByUserName(userName);
	    logger.info("+++++++username=======>"+user); 
	    
	    model.addAttribute("user", user);
	    
	    return "user/user_dashboard";
	}

	
}
