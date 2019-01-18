package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeInputBO;
import com.nt.bo.EmployeeResultBO;
import com.nt.dao.EmployeeSearchDAO;
import com.nt.dto.EmployeeInputDTO;
import com.nt.dto.EmployeeResultDTO;

@Service("empServcie")
public class EmployeeSearchServiceImpl implements EmployeeSearchService {
     @Autowired
	private EmployeeSearchDAO dao;

	

	@Override
	public List<EmployeeResultDTO> findEmployees(EmployeeInputDTO idto) {
		EmployeeInputBO ibo=null;
		List<EmployeeResultBO> listRBO=null;
		List<EmployeeResultDTO> listRDTO=new ArrayList();
		//convert dto to bo
		ibo=new EmployeeInputBO();
		BeanUtils.copyProperties(idto,ibo);
		//use DAO
		listRBO=dao.search(ibo);
		//copy listRBO to listRDTO
		listRBO.forEach(rbo->{
			EmployeeResultDTO rdto=new EmployeeResultDTO();
			BeanUtils.copyProperties(rbo,rdto);
			listRDTO.add(rdto);
		});
		return listRDTO;
	}//method

}//class
