package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.context.annotation.Description;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.lang.Nullable;

import com.nt.bo.EmployeeBO;

@Named("empDAO")
@Description(value = "DAO class")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO,MGR FROM EMP WHERE JOB IN(?,?,?)";
	@Resource
	@NonNull
	private DataSource ds;
	

	

	@Override
	public @NonNull List<EmployeeBO> fetchEmpsByDesgs(@NonNull String desg1, @NonNull String desg2, @Nullable String desg3) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<EmployeeBO> listBO=null;
		EmployeeBO bo=null;
		try{
		//get Pooled jdbc con object
		con=ds.getConnection();
		//create PreparedStatement obj
		ps=con.prepareStatement(GET_EMPS_BY_DESG);
		//set values to query params
		ps.setString(1,desg1);
		ps.setString(2,desg2);
		ps.setString(3,desg3);
		//send and execute SQL Query
		rs=ps.executeQuery();
		//copy ResultSet obj records to ListBO
		listBO=new ArrayList();
		while(rs.next()){
			//copy Each record to BO class object
			bo=new EmployeeBO();
			bo.setEmpNo(rs.getInt(1));
			bo.setEmpName(rs.getString(2));
			bo.setEmpDesg(rs.getString(3));
			bo.setEmpSalary(rs.getInt(4));
			bo.setDeptNo(rs.getInt(5));
			bo.setMgrNo(rs.getInt(6));
			//add BO class obj to List Collection
			listBO.add(bo);
		  }//while
		}//try
		catch(SQLException se){
			throw se;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			//close obj
			try{
			  if(rs!=null)
				  rs.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				  if(ps!=null)
					  ps.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}
			try{
				  if(con!=null)
					  con.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}
		}//finally
		
		return null;
	}//method
}//class
