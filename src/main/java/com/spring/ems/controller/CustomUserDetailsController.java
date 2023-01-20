package com.spring.ems.controller;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.spring.ems.beans.User;

@SuppressWarnings("serial")
public class CustomUserDetailsController implements UserDetails {
    
	private User user;
	
	public CustomUserDetailsController(User user) {
		
		super();
		this.user = user;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		//create simple granted auth. object to manage Role
		
		SimpleGrantedAuthority s_g_auth= new SimpleGrantedAuthority(user.getRole());
		
		return List.of(s_g_auth);
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		//userName as email id
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
