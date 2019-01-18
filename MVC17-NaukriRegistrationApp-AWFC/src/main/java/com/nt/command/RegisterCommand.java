package com.nt.command;

import lombok.Data;

@Data
public class RegisterCommand {
	private String name;
	private String addrs;
	private int age;
	private String domain;
	private float currentSalary;
	private float experience;
	private String prefferedLocation;
	private float expectedSalary;
	
	public RegisterCommand() {
		System.out.println("RegisterCommand::0-param constructor");
	}
	

}
