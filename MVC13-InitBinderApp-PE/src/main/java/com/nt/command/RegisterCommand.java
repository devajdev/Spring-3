package com.nt.command;

import java.util.Date;

import lombok.Data;

@Data
public class RegisterCommand {
	private String name;
	private Date  dob,dom,doj;

}
