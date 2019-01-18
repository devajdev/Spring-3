package com.nt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Named;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

@Named("controller")
public class MainController {
	@Resource
	private EmployeeMgmtService service;
	
	
	public List<EmployeeDTO> searchEmpsByDesgs(String desg1,String desg2,String desg3)throws Exception{
		List<EmployeeDTO> listDTO=null;
		//use Service class
		listDTO=service.getEmpsByDesgs(desg1, desg2, desg3);
		return listDTO;
	}

}
