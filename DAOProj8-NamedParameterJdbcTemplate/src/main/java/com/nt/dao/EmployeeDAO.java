package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface EmployeeDAO {
	public  List<EmployeeBO> getEmpBySalaryRange(int start,int end);
	public int insert(EmployeeBO bo);

}
