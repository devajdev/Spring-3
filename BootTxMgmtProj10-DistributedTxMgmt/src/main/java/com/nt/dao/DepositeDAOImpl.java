package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("depositeDAO")
public class DepositeDAOImpl implements DepositeDAO {
	private static final String DEPOSITE_QUERY="UPDATE DTX_ACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=?";
	@Autowired
	@Qualifier("mysqlTemplate")
	private JdbcTemplate jt;
	
	

	@Override
	public int deposite(int acno, float amount) {
		int count=0;
		count=jt.update(DEPOSITE_QUERY,amount,acno);
		return count;
	}

}
