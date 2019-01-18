package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeInputBO;
import com.nt.bo.EmployeeResultBO;

@Repository
public class EmployeeSearchDAOImpl implements EmployeeSearchDAO {
  private static final String SEARCH_EMPS="SELECT EMPNO,ENAME,JOB,SAL,MGR,DEPTNO FROM EMP WHERE EMPNO=? OR ENAME=? OR JOB=? OR SAL=?";
	@Autowired
  private JdbcTemplate jt;

	

	@Override
	public List<EmployeeResultBO> search(EmployeeInputBO ibo) {
       List<EmployeeResultBO> listBO=null;
       listBO=jt.query(SEARCH_EMPS,rs->{
    	   List<EmployeeResultBO> listRBO=null;
			EmployeeResultBO rbo=null;
			listRBO=new ArrayList();
			while(rs.next()) {
				rbo=new EmployeeResultBO();
				rbo.setEid(rs.getInt(1));
				rbo.setEname(rs.getString(2));
				rbo.setDesg(rs.getString(3));
				rbo.setSalary(rs.getInt(4));
				rbo.setMgrNo(rs.getInt(5));
				rbo.setDeptNo(rs.getInt(6));
				listRBO.add(rbo);
			}//while
			return listRBO;
    	   
       },ibo.getEid(),ibo.getEname(),ibo.getDesg(),ibo.getSalary());
		return listBO;
	}//method
}//class
