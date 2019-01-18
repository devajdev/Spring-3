package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nt.bo.MedicineDetailsBO;

public class MedicineDAOImpl implements MedicineDAO {
	private static final String GET_ALL_MEDICINES="SELECT MEDID,MEDNAME,FORMULAENAME,PRICE,COMPANY FROM MEDPLUSSTORE";
	private JdbcTemplate jt;
	
	

	public MedicineDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}



	@Override
	public List<MedicineDetailsBO> getAllMedicines() {
		List<MedicineDetailsBO> listBO=null;
		listBO=jt.query(GET_ALL_MEDICINES, new MedRsExtractor());
		return listBO;
	}
	
	private class MedRsExtractor implements ResultSetExtractor<List<MedicineDetailsBO>>{

		@Override
		public List<MedicineDetailsBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<MedicineDetailsBO> listBO=null;
			MedicineDetailsBO bo=null;
			listBO=new ArrayList();
			//copy ResultSet obj records to ListBO 
			while(rs.next()) {
				bo=new MedicineDetailsBO();
				bo.setMedId(rs.getInt(1));
				bo.setMedName(rs.getString(2));
				bo.setFormulaeName(rs.getString(3));
				bo.setPrice(rs.getFloat(4));
				bo.setCompany(rs.getString(5));
				listBO.add(bo);
			}
			return listBO;
		}//method
		
	}//inner class

}//outer class
