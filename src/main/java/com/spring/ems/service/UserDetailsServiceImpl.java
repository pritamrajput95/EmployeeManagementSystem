package com.spring.ems.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.ems.beans.User;
import com.spring.ems.controller.CustomUserDetailsController;
import com.spring.ems.logger.GlobalLogger;
import com.spring.ems.repository.UserRepository;

public class UserDetailsServiceImpl  implements UserDetailsService{

    private static Logger logger = GlobalLogger.getLogger(UserDetailsServiceImpl.class);

	 @Autowired
	private UserRepository userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//fetching user from database
	 User user=	userrepo.getUserByUserName(username);
	 
	  if(user==null) {
	      logger.error("+++++ could not found username !! +++++++");

		  throw new UsernameNotFoundException("could not found username !!");
	  }
	  logger.error("+++++ username found !! +++++++");
	  //get user details from CustUserdetails object
	   CustomUserDetailsController custUD= new CustomUserDetailsController(user);
	   
		return custUD;
	}

}
