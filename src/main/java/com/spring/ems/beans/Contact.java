package com.spring.ems.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CONTACT")
@NoArgsConstructor
@Setter @Getter @Data
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cId;
	private String name;
	private String othername;
	
	@Column(unique = true)
	private String email;
	
	private String work;
	private String phone;
	private String image;
	
	@Column(length = 1000)
	private String description;
	
	//many contact belong to  1 user
	@ManyToOne
    private User user;

	@Override
	public String toString() {
		return "Contact [cId=" + cId + ", name=" + name + ", othername=" + othername + ", email=" + email + ", work="
				+ work + ", phone=" + phone + ", image=" + image + ", description=" + description + ", user=" + user
				+ "]";
	}
    
	
	

	
}
