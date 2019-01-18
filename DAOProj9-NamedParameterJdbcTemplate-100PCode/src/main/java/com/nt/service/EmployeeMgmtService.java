package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeMgmtService {
   public List<EmployeeDTO> fetchEmployeesBySalaryRange(int start,int end);
   public String  registerEmp(EmployeeDTO dto);
}
