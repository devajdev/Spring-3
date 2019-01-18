package com.nt.command;


import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserCommand {
	@NotEmpty(message="user is required")
	@Length(min=3,message="user must have min of 3 chars")
	private String username;
	@NotEmpty(message="pwd is required")
	@Length(min=3,message="pwd must have min of 3 chars")
	private String password;
	private int age;
	private String domain;
	private String[] languages;
	private  Date  dob;
	
	public UserCommand() {
		System.out.println("UserCommand:0-param constructor");
	}
	
	

}
