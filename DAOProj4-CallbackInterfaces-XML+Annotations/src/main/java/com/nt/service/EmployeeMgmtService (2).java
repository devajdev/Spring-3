package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeMgmtService {
    public EmployeeDTO  findEmployeeByNo(int eno);
    public List<EmployeeDTO> findEmployeesByDesgs(String desg1,String desg2,String desg3);
}
