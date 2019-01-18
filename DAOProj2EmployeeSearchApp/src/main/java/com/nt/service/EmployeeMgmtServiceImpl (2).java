package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.EmployeeDAO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	private EmployeeDAO dao;

	public EmployeeMgmtServiceImpl(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Map<String, Object>> findEmployees(String[] desgs) {
		List<Map<String,Object>> list=null;
		String cond="";
		StringBuffer sb=new StringBuffer("");
		//prepare condition
		sb.append("(");
		for(int i=0;i<desgs.length;++i) {
			if(i==desgs.length-1)
				sb.append("'"+desgs[i]+"'");
			else
				sb.append("'"+desgs[i]+"',");
		}
		sb.append(")");
		cond=sb.toString();
		//use DAO
		list=dao.getEmployeesByDesgs(cond);
		return list;
	}//method

}//class
