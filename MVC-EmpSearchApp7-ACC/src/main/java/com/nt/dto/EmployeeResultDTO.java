package com.nt.dto;

import lombok.Data;

@Data
public class EmployeeResultDTO extends EmployeeInputDTO {
	private int mgrNo;
	private int deptNo;

}
