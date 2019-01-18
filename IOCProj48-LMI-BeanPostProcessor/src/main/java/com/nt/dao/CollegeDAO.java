package com.nt.dao;

import com.nt.bo.EmployeeBO;
import com.nt.bo.StudentBO;

public interface CollegeDAO {
	public void insertStudent(StudentBO bo);
	public void insertEmployee(EmployeeBO bo);

}
