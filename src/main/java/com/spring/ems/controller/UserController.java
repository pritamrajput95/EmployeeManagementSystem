package com.spring.ems.controller;


import java.security.Principal;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ems.beans.Contact;
import com.spring.ems.beans.User;
import com.spring.ems.logger.GlobalLogger;
import com.spring.ems.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

   private static Logger logger = GlobalLogger.getLogger(UserController.class);

   @Autowired
    UserRepository userRepo;
	
   //common model
   @ModelAttribute
   public void addCommonData(Model model,Principal principal) {
       
       String userName=principal.getName();
       logger.info("+++++++username=======>"+userName);
       
       
       User user=userRepo.getUserByUserName(userName);
       logger.info("+++++++username=======>"+user); 
       
       model.addAttribute("user", user);
   }
   
	@RequestMapping("/index")
	public String dashboard(Model model,Principal principal) {
	    logger.info("+++++ user dashboard is calling +++++++");
	  
	    model.addAttribute("title", "Home Page");
	    return "user/user_dashboard";
	}

	@RequestMapping("/add-contact")
	public  String openAddContactForm(Model model) {
	       
	    model.addAttribute("title", "Add Employee");
        model.addAttribute("contact", new Contact());

	    return "/user/add_contact_form";
	}
	
	@RequestMapping("/profile")
    public  String openProfile(Model model) {
           
        model.addAttribute("title", "Profile");
      
        return "/user/profile";
    }
	
	@RequestMapping("/changepassword")
    public  String changePassword(Model model) {
           
        model.addAttribute("title", "Change Password");
      
        return "/user/changepassword";
    }
}
