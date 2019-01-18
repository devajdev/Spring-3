package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements EmployeeDAO {
	private JdbcTemplate jt;
	

	public EmployeeDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}


	@Override
	public List<Map<String, Object>> getEmployeesByDesgs(String cond) {
		List<Map<String,Object>> listEmps=null;
		listEmps=jt.queryForList("SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN"+cond);
		return listEmps;
	}

}
