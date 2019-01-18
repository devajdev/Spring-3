package com.nt.service;

import java.util.List;

import com.nt.dto.StudentDTO;

public interface StudentService {
	public StudentDTO findStudentBySno(int sno);
	public List<StudentDTO> findStudentsByAddrs(String city1,String city2);
    public String changeStudentAddressBySno(int sno,String newAddrs);
}
