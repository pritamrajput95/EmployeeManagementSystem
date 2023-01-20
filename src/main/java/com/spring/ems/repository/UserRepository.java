package com.spring.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.spring.ems.beans.User;

@EnableJpaRepositories
public interface UserRepository  extends JpaRepository<User,Integer>{

	//method for get user by userName
	
	@Query("select u from User u  where u.email	= :email ")
	public User getUserByUserName(@Param("email") String email);
	
}
