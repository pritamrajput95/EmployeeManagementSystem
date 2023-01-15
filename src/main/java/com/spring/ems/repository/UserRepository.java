package com.spring.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spring.ems.beans.User;

@EnableJpaRepositories
public interface UserRepository  extends JpaRepository<User,Integer>{

}
