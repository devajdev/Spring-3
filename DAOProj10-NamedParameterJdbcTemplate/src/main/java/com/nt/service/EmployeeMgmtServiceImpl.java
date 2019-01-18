package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;
@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService{
	@Autowired
	private EmployeeDAO dao;

	@Override
	public List<EmployeeDTO> fetchEmployeesBySalaryRange(int start, int end) {
      List<EmployeeBO> listBO=null;
      List<EmployeeDTO> listDTO=new ArrayList();
		//use DAO
      listBO=dao.getEmpBySalaryRange(start, end);
      //copy listBO to listDTO
       listBO.forEach(bo->{
    	   EmployeeDTO dto=new EmployeeDTO();
    	   BeanUtils.copyProperties(bo,dto);
    	   listDTO.add(dto);
       });
		return listDTO;
	}//method
	
	@Override
	public String registerEmp(EmployeeDTO dto) {
		EmployeeBO bo=null;
		int count=0;
	   //convert DTO to BO
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.insert(bo);
		if(count==0)
			return "registration failed";
		else
			return "registration succeded";
	}//method
	
}//class
