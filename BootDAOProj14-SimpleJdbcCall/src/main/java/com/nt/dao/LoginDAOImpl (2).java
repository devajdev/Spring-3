package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nt.bo.UserBO;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
	
	private SimpleJdbcCall sjc;
	
	public  LoginDAOImpl(@Autowired DataSource ds) {
		sjc=new SimpleJdbcCall(ds);
	}

	@Override
	public String validate(UserBO bo) {
		Map<String,Object> inParamMap=null;
		Map<String,Object> outParamMap=null;
		String result=null;
		//set Procedure name
		sjc.setProcedureName("P_AUTHENTICATION");
		//create Map obj having IN params and values
		inParamMap=new HashMap();
		inParamMap.put("un",bo.getUsername());
		inParamMap.put("pass",bo.getPassword());
		//call PL/SQL procedure
		outParamMap=sjc.execute(inParamMap);
		System.out.println(outParamMap);
		//gather result from outParamMap
		result=(String) outParamMap.get("RESULT");
        return result;
	}//method
}//class
