package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
   public int getEmployeeCount();
   public  float getEmployeeSalaryByNo(int empno);
   public Map<String,Object> getEmployeeByNo(int empNo);
   public List<Map<String,Object>> getEmployeesByDesgs(String desg1,String desg2,String desg3);
   public  int  updateSalaryByNo(int empNo,int newSalary);
   public  int registerEmployee(int empNo,String ename,String desg,int salary);
   public int  fireEmployee(int empNo);
}
