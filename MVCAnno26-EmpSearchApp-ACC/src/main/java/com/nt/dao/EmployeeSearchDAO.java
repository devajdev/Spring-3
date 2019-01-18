package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeInputBO;
import com.nt.bo.EmployeeResultBO;

public interface EmployeeSearchDAO {
   public List<EmployeeResultBO> search(EmployeeInputBO ibo);
}
