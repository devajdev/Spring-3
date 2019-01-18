package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.EmployeeDAO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	private EmployeeDAO dao;
	
	public EmployeeMgmtServiceImpl(EmployeeDAO dao) {
		this.dao = dao;
	}


	@Override
	public int findEmployeesCount() {
		int count=0;
	//use DAO
		count=dao.getEmployeeCount();
		return count;
	}
	
	@Override
	public float findEmployeeSalaryByNo(int empNo) {
		float salary=0.0f;
		//use DAO
		salary=dao.getEmployeeSalaryByNo(empNo);
		return salary;
	}
	
	@Override
	public Map findEmplyeeDetailsByNo(int empNo) {
		Map<String,Object>  map=null;
		//use DAO
		map=dao.getEmployeeByNo(empNo);
		return map;
	}


	@Override
	public List<Map<String, Object>> findEmployeesByDesgs(String desg1, String desg2, String desg3) {
		List<Map<String,Object>> list=null;
		//use DAO
		list=dao.getEmployeesByDesgs(desg1, desg2, desg3);
		return list;
	}
	
	@Override
	public String hikeSalaryByEmpNo(int empNo, float percentage) {
		float salary=0.0f;
		float newSalary=0.0f;
		int count=0;
		//get Existing salary
		salary=dao.getEmployeeSalaryByNo(empNo);
		//hike salary
		newSalary=salary+ (salary*percentage/100.0f);
		//use DAO
		count=dao.updateSalaryByNo(empNo, Math.round(newSalary));
		
		if(count==0)
			return "Problem in updating "+empNo+" salary";
		else
			return empNo+"salary hiked and new salary is"+newSalary;
	}//method
	
	@Override
	public String registerEmployee(int empNo, String ename, String desg, int salary) {
		int count=0;
		//use DAO
		count=dao.registerEmployee(empNo, ename, desg, salary);
		if(count==0)
			return "registration failed";
		else
			return "registration succeded with empNo::"+empNo;
	}
	
	@Override
	public String fireEmployee(int empNo) {
		int count=0;
		//use DAO
		count=dao.fireEmployee(empNo);
		if(count==0)
			return "Employee not fired";
		else
			return "Employee fired";
	}
	
}//class
