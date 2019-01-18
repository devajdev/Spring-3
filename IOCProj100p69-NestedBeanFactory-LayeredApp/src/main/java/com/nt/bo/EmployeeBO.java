package com.nt.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Data
//@NoArgsConstructor
//@RequiredArgsConstructor
public class EmployeeBO {
	private  int empNo;
	private  String empName;
	private  String empDesg;
	private int empSalary;
	private int deptNo;
	private int mgrNo;
	

}
