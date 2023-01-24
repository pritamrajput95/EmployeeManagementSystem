package com.spring.ems.config;

import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.ems.logger.GlobalLogger;
import com.spring.ems.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {
    private static Logger logger = GlobalLogger.getLogger(MyConfig.class);
    
    @Bean
    public UserDetailsService getUserDetailsService() {
        //creating userDetails service Method
        logger.info("+++++ MyConfig class executed +++++++");
        
        logger.info("+++++ getUserDetailsService method() call +++++++");
        
        return new UserDetailsServiceImpl();
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        //creating BCryptePasssword Method
        logger.info("+++++ passwordEncoder method() call +++++++");
        
        return new BCryptPasswordEncoder();
    }
    
    //creating DaoAuthenticationProvider method
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        logger.info("+++++ DaoAuthenticationProvider object created +++++++");
        
        //creating DAO object
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        
        //set user details and password using DAO object reference variable
        logger.info("+++++ set user details and password using DAO object ref +++++++");
        
        daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        
        return daoAuthenticationProvider;
        
    }
    
    // configuration 2 method....
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        logger.info("+++++ configure(auth)  method() +++++++");
        
        //calling authenticationProvider method
        auth.authenticationProvider(authenticationProvider());
        
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("+++++ configure(http) method() start +++++++");
        
        //managing access Level using HttpSecurity  for user and admin
        
        http.authorizeHttpRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole("USER")
                .antMatchers("/**").permitAll().and()
                .formLogin().loginPage("/signin")
                .loginProcessingUrl("/do_login")
                .defaultSuccessUrl("/user/index")
               // .defaultSuccessUrl("/admin/home")
                //.failureUrl("/login-failed")
                .and().csrf().disable();
        
        logger.info("+++++ configure(http) method() close +++++++");
        
    }
    
}
