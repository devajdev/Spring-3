package com.nt.service;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EnggAspraintBO;
import com.nt.dao.OnlineCounsellingDAO;
import com.nt.dto.EnggAspraintDTO;

@Service("oCService")
public class OnlineCounsellingMgmtServiceImpl implements OnlineCousellingMgmtService {
     @Autowired
	private OnlineCounsellingDAO dao;
	
	@Override
	public String register(EnggAspraintDTO dto) {
		java.util.Date udob=null;
		java.sql.Date sqdob=null;
		SimpleDateFormat sdf=null;
		EnggAspraintBO bo=null;
		int count=0;
		//convert java.util.Date to java.sql.Date
		udob=dto.getDob();
		sqdob=new java.sql.Date(udob.getTime());
		//convert DTO to BO
		bo=new EnggAspraintBO();
		bo.setHtNo(dto.getHtNo());
		bo.setRank(dto.getRank());
		bo.setDob(sqdob);
		bo.setPrefferedColleges(dto.getPrefferedColleges());
		bo.setPrefferedStreams(dto.getPrefferedStreams());
		//use DAO
		count=dao.insert(bo);
		//process the result
		if(count==0)
			return "Registration Failed";
		else
			return "Registration success";
	}

}
