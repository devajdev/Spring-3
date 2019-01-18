package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeInputDTO;
import com.nt.dto.EmployeeResultDTO;

public interface EmployeeSearchService {
	public List<EmployeeResultDTO> findEmployees(EmployeeInputDTO idto);

}
