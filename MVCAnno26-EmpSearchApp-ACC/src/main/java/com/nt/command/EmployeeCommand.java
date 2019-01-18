package com.nt.command;

import lombok.Data;

@Data
public class EmployeeCommand {
	private int eid;
	private String ename;
	private String desg;
	private  int salary;
	
	public  EmployeeCommand() {
		System.out.println("EmployeeCommand::0-param constructor");
	}

}
