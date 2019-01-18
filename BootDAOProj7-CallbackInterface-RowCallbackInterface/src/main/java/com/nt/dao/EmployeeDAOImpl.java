package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMP_BY_NO="SELECT EMPNO as eno,ENAME as ename,JOB as job,SAL as salary FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO as eno,ENAME as ename,JOB as job,SAL as salary FROM EMP WHERE JOB IN(?,?,?)";
	@Autowired
	private JdbcTemplate jt;

	
		
	
  @Override
	public EmployeeBO getEmployeeDetailsByNo(int eid) {
		EmployeeBO ebo=null;
		ebo=jt.queryForObject(GET_EMP_BY_NO,
				              new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class),
				              eid);
		return ebo;
  }//method
  
/*  @Override
public List<EmployeeBO> getEmployeesDetailsByDesgs(String desg1, String desg2, String desg3) {
	  List<EmployeeBO> listBO=null;
	  listBO=new ArrayList();
	  jt.query(GET_EMPS_BY_DESGS,
			  new EmployeeRowCallbackHandler(listBO),
			  desg1,desg2,desg3);
	  
	return listBO;
}
  
  private class EmployeeRowCallbackHandler implements RowCallbackHandler{
       private List<EmployeeBO>  listBO;
	  public EmployeeRowCallbackHandler(List<EmployeeBO> listBO) {
		this.listBO=listBO;
	}
	@Override
	public void processRow(ResultSet rs) throws SQLException {
		System.out.println("processRow(-) method");
		EmployeeBO bo=null;
		bo=new EmployeeBO();
		bo.setEno(rs.getInt(1));
		bo.setEname(rs.getString(2));
		bo.setJob(rs.getString(3));
		bo.setSalary(rs.getInt(4));
		listBO.add(bo);
	}//processRow(-)
  
  
  }//inner class
  */
  
  @Override
  public List<EmployeeBO> getEmployeesDetailsByDesgs(String desg1, String desg2, String desg3) {
  	  List<EmployeeBO> listBO=new ArrayList();
  	  jt.query(GET_EMPS_BY_DESGS,
  			   rs->{
                   System.out.println("111");
  				   EmployeeBO bo=new EmployeeBO();
  				   bo.setEno(rs.getInt(1));
  				   bo.setEname(rs.getString(2));
  				   bo.setJob(rs.getString(3));
  				   bo.setSalary(rs.getInt(4));
  				   listBO.add(bo);
  			   }
  			   ,
  			   desg1,desg2,desg3);
  	  return listBO;
  }
  
}//class