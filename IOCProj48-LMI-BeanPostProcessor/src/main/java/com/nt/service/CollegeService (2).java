package com.nt.service;

import com.nt.bo.EmployeeBO;
import com.nt.bo.StudentBO;
import com.nt.dao.CollegeDAO;

public abstract class CollegeService {
	private CollegeDAO dao;
	public CollegeService(CollegeDAO dao){
		System.out.println("CollegeService:1-param constructor");
		this.dao=dao;
	}
	/*  In support to Lookup Method Injection */
	public abstract StudentBO getStudentBO();
	public abstract EmployeeBO getEmployeeBO();
	/* business methods	 */
	public  void registerStudent(int id,String name,String course){
		System.out.println("CollegeService.registerStudent(-,-,-)");
		StudentBO bo=null;
		//get StudentBO class object
		bo=getStudentBO();
		bo.setId(id);
		bo.setName(name);
		bo.setCourse(course);
		//use DAO
		dao.insertStudent(bo);
	}
	
	public  void registerEmployee(int id,String name,String desg){
		System.out.println("CollegeService.registerEmployee(-,-,-)");
		EmployeeBO bo=null;
		//get StudentBO class object
		bo=getEmployeeBO();
		bo.setId(id);
		bo.setName(name);
		bo.setDesg(desg);
		//use DAO
		dao.insertEmployee(bo);
	}

}
