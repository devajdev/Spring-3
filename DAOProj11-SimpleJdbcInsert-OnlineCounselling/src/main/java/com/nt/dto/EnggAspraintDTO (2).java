package com.nt.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class EnggAspraintDTO implements Serializable {
	private int htNo;
	private int rank;
	private Date dob;
	private String prefferedStreams;
	private String prefferedColleges;
}
