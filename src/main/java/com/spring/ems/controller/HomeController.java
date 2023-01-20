package com.spring.ems.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.log4j.Logger;

import com.spring.ems.beans.User;
import com.spring.ems.helper.Message;
import com.spring.ems.repository.UserRepository;

@Controller
public class HomeController {

	private static final Logger LOGGER = Logger.getLogger(HomeController.class);

	@Autowired
	private BCryptPasswordEncoder passwardEncoder;
	
	@Autowired
	private  UserRepository userRepo;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home - EMS");
		System.out.println("home page called....");
       LOGGER.info("@@@@@@@@@@@@@@@@@@");
		return "home";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "about - EMS");
		System.out.println("about page called....");
		
		return "about";
	}
	
	@RequestMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("title", "contact - EMS");
		System.out.println("contact page called....");
		
		return "contact";
	}

	@RequestMapping("/signup")
	public String signup(Model model) {
		
		model.addAttribute("title", "Register - EMS");
		System.out.println("signup page called....");
		model.addAttribute("user", new User());

		return "signup";
	}

	
	// handler for register user

	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result1,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,HttpSession session) 
	{
		
		System.out.println("register  page called...");
		
		try {
			
			if(!agreement) {
				
				throw new Exception(" you have not agreed the term and condition");
			}
			
			if(result1.hasErrors()) {
				System.out.println("ERROR "+result1.toString());
				model.addAttribute("user", user);
				return "signup";
			}
			
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("default.png");
		
			//setting encode password 
			user.setPassword(passwardEncoder.encode(user.getPassword()));
			
			System.out.println("Agreement==>"+agreement);
			System.out.println("USER==>"+user);
			
			//save data into database
			User result=userRepo.save(user);
		
			model.addAttribute("user",new User());
			
			session.setAttribute("message", new Message("Successfully Regisered...!!","alert-success"));
			
			System.out.println(result);
			System.out.println("user saved successfully...!");
			
			return "signup";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("Something went wrong...!! "+e.getMessage(),"alert-danger"));
			return "signup";
		} 
		
		
		
	}

	
	@GetMapping("/signin")
	public String  CustomLogin(Model model) {
		model.addAttribute("title", "Login - EMS");
		
		System.out.println("login page called....signin");
		
		return "login2";
	}

}
