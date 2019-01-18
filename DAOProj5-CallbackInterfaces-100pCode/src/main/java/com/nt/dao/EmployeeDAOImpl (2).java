package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMP_BY_NO="SELECT EMPNO as eno,ENAME as ename,JOB as job,SAL as salary FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO as eno,ENAME as ename,JOB as job,SAL as salary FROM EMP WHERE JOB IN(?,?,?)";
	@Autowired
	private JdbcTemplate jt;

	
	/*@Override
	public EmployeeBO getEmployeeDetailsByNo(int eid) {
		EmployeeBO bo=null;
		bo=jt.queryForObject(GET_EMP_BY_NO,
				    new RowMapper<EmployeeBO>(){

			@Override
			public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			    EmployeeBO bo=null;
				bo=new EmployeeBO();
				bo.setEno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSalary(rs.getInt(4));
				return bo;
			}//mapRow(-,-)
		} //anonymous inner class
		,eid);
		
		return bo;
	}*/
	
	/*private class EmployeeRowMapper implements RowMapper<EmployeeBO>{

		@Override
		public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeBO bo=null;
			//copy ResultSet obj record to BO class object
			bo=new EmployeeBO();
			bo.setEno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSalary(rs.getInt(4));
			return bo;
		}
		
	}
*/
	
	/*@Override
	public EmployeeBO getEmployeeDetailsByNo(int eid) {
		EmployeeBO ebo=null;
		ebo=jt.queryForObject(GET_EMP_BY_NO,(rs,rowNum)->{
			EmployeeBO bo=null;
			//copy ResultSet obj record to BO class object
			bo=new EmployeeBO();
			bo.setEno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSalary(rs.getInt(4));
			return bo;
		},
	    eid);
		return ebo;
  }//method */
  
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
  listBO=jt.query(GET_EMPS_BY_DESGS,
		          new  ResultSetExtractor<List<EmployeeBO>>(){
	                @Override
	                  public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
	            	    List<EmployeeBO> listBO=null;
	            	    EmployeeBO bo=null;
	            	    //copy ResultSet obj records ListBO
	            	    listBO=new ArrayList();
	            	    while(rs.next()) {
	            	    	//copy each record of RS to BO class obj
	            	      bo=new EmployeeBO();
	            	      bo.setEno(rs.getInt(1));
	            	      bo.setEname(rs.getString(2));
	            	      bo.setJob(rs.getString(3));
	            	      bo.setSalary(rs.getInt(4));
	            	      listBO.add(bo);
	            	    }//while
	            	     return listBO;
	                  }//extractData
	                 }//anonymous inner class     
  		           ,
		           desg1,desg2,desg3);
 return listBO;
}//method
*/  
  
  /*public List<EmployeeBO> getEmployeesDetailsByDesgs(String desg1, String desg2, String desg3) {
	  List<EmployeeBO> listBO=null;
	  listBO=jt.query(GET_EMPS_BY_DESGS,rs->{
		  List<EmployeeBO> listBO1=null;
  	    EmployeeBO bo=null;
  	    //copy ResultSet obj records ListBO
  	    listBO1=new ArrayList();
  	    while(rs.next()) {
  	    	//copy each record of RS to BO class obj
  	      bo=new EmployeeBO();
  	      bo.setEno(rs.getInt(1));
  	      bo.setEname(rs.getString(2));
  	      bo.setJob(rs.getString(3));
  	      bo.setSalary(rs.getInt(4));
  	      listBO1.add(bo); 
  	    }
  	    return listBO1;
	  },
	  desg1,desg2,desg3);
	  return listBO;
  }//method
*/  
  
  public List<EmployeeBO> getEmployeesDetailsByDesgs(String desg1, String desg2, String desg3) {
	  List<EmployeeBO> listBO=null;
	  BeanPropertyRowMapper<EmployeeBO> rowMapper=null;
	  //create RowMapper object
	  rowMapper=new BeanPropertyRowMapper(EmployeeBO.class);
	  listBO=(List<EmployeeBO>) jt.query(GET_EMPS_BY_DESGS,
			          new RowMapperResultSetExtractor(rowMapper),
			          desg1,desg2,desg3);
    return listBO;
  }
  
  
}//class