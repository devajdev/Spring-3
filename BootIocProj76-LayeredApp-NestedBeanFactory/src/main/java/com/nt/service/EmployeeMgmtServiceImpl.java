package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Named("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
    @Resource
	private EmployeeDAO dao;

	@Override
	public List<EmployeeDTO> getEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<EmployeeBO> listBO=null;
		 List<EmployeeDTO> listDTO=new ArrayList();
		
		//use DAO
		listBO=dao.fetchEmpsByDesgs(desg1, desg2, desg3);
		//convert listBO to listDTO
		System.out.println("Results"+listBO.size());
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			dto.setSno(listDTO.size()+1);
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
			
		});
		
			return listDTO;
	}

}
