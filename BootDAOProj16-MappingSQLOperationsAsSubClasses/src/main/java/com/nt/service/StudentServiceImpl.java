package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

@Service("studService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO dao; 

	@Override
	public StudentDTO findStudentBySno(int sno) {
		StudentDTO dto=null;
		StudentBO bo=null;
		//use DAO
		bo=dao.getStudentByNo(sno);
		//Convert BO class obj to DTO class object
		dto=new StudentDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public List<StudentDTO> findStudentsByAddrs(String city1, String city2) {
		List<StudentDTO> listDTO=new ArrayList();
		List<StudentBO> listBO=null;
		//use DAO
		listBO=dao.getStudentsByAddrs(city1, city2);
		//convert listBO to listDTO
		listBO.forEach(bo->{
			StudentDTO dto=new StudentDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		});
		return listDTO;
	}//method
	
	@Override
	public String changeStudentAddressBySno(int sno, String newAddrs) {
		int count=0;
		//use DAO
		count=dao.updateStudentAddrsBySno(sno, newAddrs);
		if(count==0)
			return "Record not found for updation";
		else
			return "Record found for updation";
	}

}
