package com.nt.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.TicketDetialsBO;

@Repository("TADAO")
public class TravelAgentDAOImpl implements TravelAgentDAO {
	private static final String TICKET_INSERT_QUERY="INSERT INTO RAILTICKETRESERVATION VALUES(TICKETID_SEQ.NEXTVAL,?,?,?,?,?)";
    @Autowired
	private JdbcTemplate jt;
  
	public int[] insert(final List<TicketDetialsBO> listBO) {
		int result[]=null;
		result=jt.batchUpdate(TICKET_INSERT_QUERY,
				             new BatchPreparedStatementSetter() {
								
								public void setValues(PreparedStatement ps, int i) throws SQLException {
									System.out.println(
											"TravelAgentDAOImpl.insert(...).new BatchPreparedStatementSetter() {...}.setValues()");
								   ps.setString(1,listBO.get(i).getPsgName() );
								   ps.setInt(2,listBO.get(i).getAge() );
								   ps.setString(3,listBO.get(i).getSource());
								   ps.setString(4,listBO.get(i).getDest() );
								   ps.setDate(5,new java.sql.Date(new java.util.Date().getTime()));
								}
								
								public int getBatchSize() {
									System.out.println(
											"TravelAgentDAOImpl.insert(...).new BatchPreparedStatementSetter() {...}.getBatchSize()");
									return listBO.size();
								}
							});
		return result;
	}//method
}//class
