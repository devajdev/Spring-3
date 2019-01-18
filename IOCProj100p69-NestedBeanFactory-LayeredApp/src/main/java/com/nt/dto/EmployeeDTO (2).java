package com.nt.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeDTO implements Serializable {
	private int sno;
	
	private int empNo;
	private String empName;
	private String empDesg;
	private int empSalary;
	private int deptNo;
	private int mgrNo;
	

}
