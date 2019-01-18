package com.nt.dao;

import java.util.List;

import com.nt.bo.StudentBO;

public interface StudentDAO {
  public StudentBO getStudentByNo(int no);
  public List<StudentBO> getStudentsByAddrs(String city1,String city2);
  public int updateStudentAddrsBySno(int sno,String newAddrs);
}
