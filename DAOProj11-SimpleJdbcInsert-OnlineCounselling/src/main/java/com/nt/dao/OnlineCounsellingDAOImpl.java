package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.bo.EnggAspraintBO;
@Repository
public class OnlineCounsellingDAOImpl implements OnlineCounsellingDAO {
   @Autowired
	private SimpleJdbcInsert sji;
   
	/*@Override
	public int insert(EnggAspraintBO bo) {
		Map<String,Object> map=null;
		int result=0;
		//set Table name
		sji.setTableName("EnggCounselling");
		//set col names and values
		map=new HashMap();
		map.put("HTNO",bo.getHtNo());
		map.put("RANK", bo.getRank());
		map.put("DOB",bo.getDob());
		map.put("prefferedStreams",bo.getPrefferedStreams());
		map.put("prefferedColleges",bo.getPrefferedColleges());
		//execute Query
		result=sji.execute(map);
		return result;
	}*/
   
   @Override
	public int insert(EnggAspraintBO bo) {
       BeanPropertySqlParameterSource bsps=null;
		int result=0;
		//set Table name
		sji.setTableName("EnggCounselling");
		//set col names and values
		bsps=new BeanPropertySqlParameterSource(bo);
		//execute Query
		result=sji.execute(bsps);
		return result;
	}

}
