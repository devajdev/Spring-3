package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	
	private EmployeeDAO dao;
	

	public EmployeeMgmtServiceImpl(EmployeeDAO dao) {
		this.dao = dao;
	}


	@Override
	public EmployeeDTO findEmployeeByNo(int eno) {
		EmployeeBO bo=null;
		EmployeeDTO dto=null;
       //use DAO
		bo=dao.getEmployeeDetailsByNo(eno);
		//Convert BO to DTO
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
	
	@Override
	public List<EmployeeDTO> findEmployeesByDesgs(String desg1, String desg2, String desg3) {
		List<EmployeeDTO> listDTO=new ArrayList();
		List<EmployeeBO> listBO=null;
		//use DAO
		listBO=dao.getEmployeesDetailsByDesgs(desg1, desg2, desg3);
		//copy listBO to listDTO
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			//add dto to listDTO
			listDTO.add(dto);
		});
		return listDTO;
	}//method
}//class
