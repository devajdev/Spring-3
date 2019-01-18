package com.nt.service;

import java.util.List;
import java.util.Map;

public interface EmployeeMgmtService {
   public  int findEmployeesCount();
   public  float findEmployeeSalaryByNo(int empNo);
   public  Map findEmplyeeDetailsByNo(int empNo);
   public List<Map<String,Object>> findEmployeesByDesgs(String desg1,String desg2,String desg3);
   public  String hikeSalaryByEmpNo(int empNo,float percentage);
   public String  registerEmployee(int empNo,String ename,String desg,int salary);
   public String fireEmployee(int empNo);
}
