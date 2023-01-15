package com.spring.ems.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@Setter @Getter @Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String name;
	
	//@Column(unique = true)
	private String email;
	
	private String password;
	private String role;
	private String imageUrl;
	private boolean enabled;
	
	@Column(length = 500)
	private String  about;
	
	
	//one user have multiple contact
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
	private List<Contact> contacts= new ArrayList<>();


	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + ", imageUrl=" + imageUrl + ", enabled=" + enabled + ", about=" + about + ", contacts="
				+ contacts + "]";
	}
	
	
	
}
