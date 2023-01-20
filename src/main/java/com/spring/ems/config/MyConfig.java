package com.spring.ems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.ems.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter  {
    
	@Bean
	public UserDetailsService getUserDetailsService() {
		//creating userDetails service Method
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		//creating BCryptePasssword Method
		return new BCryptPasswordEncoder(); 
	}
	
	   //creating DaoAuthenticationProvider method
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		//creating DAO object
		DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider();
		
		//set user details and password using DAO object reference variable
		
		daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return daoAuthenticationProvider;
		
		
	}

	// configuration 2 method....
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//calling authenticationProvider method
		auth.authenticationProvider(authenticationProvider());
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//managing access Level using HttpSecurity  for user and admin
		
		http.authorizeHttpRequests().antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/**").hasRole("USER")
		.antMatchers("/**").permitAll().and().formLogin().loginPage("/signin").and().csrf().disable();
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
