package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Repository("stDAO")
public class StudentDAOImpl implements StudentDAO {
	private static final String  STUDENT_INSERT_QUERY="INSERT INTO SPRING_STUDENT VALUES(SNO_SEQ.NEXTVAL,?,?,?,?)";
	@Autowired
	private DataSource ds;

	
	
	

	@Override
	public int insert(StudentBO bo) throws Exception {
		System.out.println(ds.getClass());
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get jdbc con obj from pooled connection
		con=ds.getConnection();
		//create PreparedStatement obj
		ps=con.prepareStatement(STUDENT_INSERT_QUERY);
		//set BO data as the query param values
		ps.setString(1,bo.getSname());
		ps.setInt(2,bo.getTotal());
		ps.setFloat(3,bo.getAvg());
		ps.setString(4,bo.getResult());
		//execute the query
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}

}
