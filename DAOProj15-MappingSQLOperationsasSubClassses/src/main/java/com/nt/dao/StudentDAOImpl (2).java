package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Repository
public class StudentDAOImpl implements StudentDAO{
	   private static final String GET_STUD_BY_NO="SELECT SNO,SNAME,SADD FROM STUDENT WHERE SNO=?";
	   private static final String GET_STUDS_BY_ADDRS="SELECT SNO,SNAME,SADD FROM STUDENT WHERE SADD IN(?,?)";
	   private static final String  UPDATE_ADDRS_BY_SNO="UPDATE STUDENT SET SADD=? WHERE SNO=?";
	   
	   private StudentSelector stSelector=null;
	    private StudentSelector1  stSelector1=null;
	    private StudentUpdator stUpdator=null;
	   
	    @Autowired
	    public  StudentDAOImpl(DataSource ds){
	    	System.out.println("StudentDAOImpl.1-param constructor");
	      stSelector=new StudentSelector(ds,GET_STUD_BY_NO);
	      stSelector1=new StudentSelector1(ds, GET_STUDS_BY_ADDRS);
	      stUpdator=new StudentUpdator(ds, UPDATE_ADDRS_BY_SNO);
	  }

	    //persistence method1
	  public  StudentBO  getStudentByNo(int sno){
	           StudentBO bo=null;
	             bo=stSelector.findObject(sno);
	            return bo;
	  } 
	  
	 //persitence method2
	  @Override
	public List<StudentBO> getStudentsByAddrs(String city1, String city2) {
		List<StudentBO> listBO=null;
		listBO=stSelector1.execute(city1,city2);
		return listBO;
	}
	  
	  //persistnece method3
	  @Override
		public int updateStudentAddrsBySno(int sno, String newAddrs) {
			int count=0;
			count=stUpdator.update(newAddrs, sno);
			return count;
		}

	//inner class1
	     private class StudentSelector extends MappingSqlQuery<StudentBO>{

	           public  StudentSelector(DataSource ds,String query){
	                     super(ds,query);
	                     System.out.println("StudentDAOImpl.2-param constructor");
	                    super.declareParameter(new SqlParameter(Types.INTEGER));
	                    super.compile();
	             }

	             public StudentBO  mapRow(ResultSet rs,int index)throws SQLException{
	            	 System.out.println("StudentDAOImpl.StudentSelector.mapRow(-)");
	                  StudentBO bo=null;
	                     bo=new StudentBO();
	                     bo.setSno(rs.getInt(1));
	                     bo.setSname(rs.getString(2));
	                    bo.setSadd(rs.getString(3));
	                    return bo;
	            }

	     }//inner class1
	     
	     //inner class2
	  private class StudentSelector1 extends MappingSqlQuery<StudentBO>{
		  
		  public StudentSelector1(DataSource ds,String query) {
			super(ds,query);
		  System.out.println("StudentDAOImpl.StudentSelector1.2-param construtor");
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.compile();
		}

		@Override
		protected StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			 System.out.println("StudentDAOImpl.StudentSelector1.mapRow(-)");
             StudentBO bo=null;
                bo=new StudentBO();
                bo.setSno(rs.getInt(1));
                bo.setSname(rs.getString(2));
               bo.setSadd(rs.getString(3));
               return bo;
		}
		  
	  }//inner class2
	  
	  //inner class3
	  public class StudentUpdator extends SqlUpdate{
		   public StudentUpdator(DataSource ds,String query) {
			super(ds,query);
			System.out.println("StudentDAOImpl.StudentUpdator.2-param cosntructor");
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.INTEGER));
	        super.compile();		
		}
	
	  }//inner class3
	}//outer class