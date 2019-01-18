package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMPS_COUNT = "SELECT COUNT(*) FROM EMP";
    private static final String GET_EMP_SAL_BY_EMPNO="SELECT SAL FROM EMP WHERE EMPNO=?";
    private static final String GET_EMP_BY_EMPNO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
    private static final String GET_EMP_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
    private static final String UPDATE_EMP_SAL_BY_NO="UPDATE EMP SET SAL=? WHERE EMPNO=?";
    private static final String INSERT_EMP="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(?,?,?,?)";
    private static final String DELETE_EMP_BY_NO="DELETE FROM EMP WHERE EMPNO=?"; 
    private JdbcTemplate jt;

	public EmployeeDAOImpl(JdbcTemplate jt) {

		this.jt = jt;
	}

	@Override
	public int getEmployeeCount() {
		int count=0;
		count=jt.queryForObject(GET_EMPS_COUNT, Integer.class);
		return count;
	}
	
	@Override
	public float getEmployeeSalaryByNo(int empno) {
		float salary=0;
		salary=jt.queryForObject(GET_EMP_SAL_BY_EMPNO,Float.class,empno);
		return salary;
	}
	
	@Override
	public Map<String, Object> getEmployeeByNo(int empNo) {
		Map<String,Object> map=null;
		map=jt.queryForMap(GET_EMP_BY_EMPNO,empNo);
		return map;
	}
	
	@Override
	public List<Map<String, Object>> getEmployeesByDesgs(String desg1, String desg2, String desg3) {
		List<Map<String,Object>> list=null;
		
		list=jt.queryForList(GET_EMP_BY_DESGS,desg1,desg2,desg3);
		return list;

	}
	
	@Override
	public int updateSalaryByNo(int empNo, int newSalary) {
		int count=0;
		count=jt.update(UPDATE_EMP_SAL_BY_NO, newSalary,empNo);
		return count;
	}
	
	
	@Override
	public int registerEmployee(int empNo, String ename, String desg, int salary) {
		int count=0;
		count=jt.update(INSERT_EMP, empNo,ename,desg,salary);
		return count;
	}
	
	@Override
	public int fireEmployee(int empNo) {
		return jt.update(DELETE_EMP_BY_NO,empNo);
	}
	
	

}