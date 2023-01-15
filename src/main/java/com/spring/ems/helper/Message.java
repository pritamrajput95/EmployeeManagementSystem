package com.spring.ems.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class Message {

	private String content;
	private String type;
	
	@Override
	public String toString() {
		return "Message [content=" + content + ", type=" + type + "]";
	}
	
	
	
	
	
}
