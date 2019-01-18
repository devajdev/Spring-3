package com.nt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMPS_BY_SAL_RANGE="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL>=:min AND SAL<=:max";
	private static final String INSERT_EMP="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(:eno,:ename,:desg,:salary)";
	@Autowired
	private NamedParameterJdbcTemplate njt;

	@Override
	public List<EmployeeBO> getEmpBySalaryRange(int start, int end) {
	  Map<String,Object> paramMap=null;
	  List<EmployeeBO> listBO=null;
		//prepare ParamMap
	  paramMap=new HashMap();
	  paramMap.put("min",start);
	  paramMap.put("max",end);
	  //execute the Query
	  listBO=njt.query(GET_EMPS_BY_SAL_RANGE,
			           paramMap,
			           rs->{
			        	   List<EmployeeBO> listBO1=new ArrayList();
			             while(rs.next()) {
			            	 EmployeeBO bo=new EmployeeBO();
			            	bo.setEno(rs.getInt(1));
			            	bo.setEname(rs.getString(2));
			            	bo.setDesg(rs.getString(3));
			            	bo.setSalary(rs.getInt(4));
			            	listBO1.add(bo);
			             }//while
			             return listBO1;
			           });
    return listBO;	  
	}//method
	
	/*@Override
	public int insert(EmployeeBO bo) {
		MapSqlParameterSource msps=null;
		int count=0;
		msps=new MapSqlParameterSource();
		msps.addValue("eno",bo.getEno());
		msps.addValue("ename",bo.getEname());
		msps.addValue("desg",bo.getDesg());
		msps.addValue("salary",bo.getSalary());
		//execute the query
		count=njt.update(INSERT_EMP, msps);
		return count;
	}*/
	
	@Override
	public int insert(EmployeeBO bo) {
		BeanPropertySqlParameterSource bpsps=null;
		int count=0;
		bpsps=new BeanPropertySqlParameterSource(bo);
		//execute the query
		count=njt.update(INSERT_EMP, bpsps);
		return count;
	}

}//class
