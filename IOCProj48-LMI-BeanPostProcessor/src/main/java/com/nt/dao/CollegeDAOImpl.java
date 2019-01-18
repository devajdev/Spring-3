package com.nt.dao;

import com.nt.bo.EmployeeBO;
import com.nt.bo.StudentBO;

public class CollegeDAOImpl implements CollegeDAO {
	
	public CollegeDAOImpl() {
		System.out.println("CollegeDAOImpl:0-param constructor");
	}

	@Override
	public void insertStudent(StudentBO bo) {
		System.out.println("inserting student Info having data"+bo.getId()+" "+bo.getName()+" "+bo.getCourse()+" "+bo.getDoj());
	}

	@Override
	public void insertEmployee(EmployeeBO bo) {
		System.out.println("inserting Employee Info having data"+bo.getId()+" "+bo.getName()+" "+bo.getDesg()+" "+bo.getDoj());
	}

}
