package com.nt.bo;

import java.sql.Date;

import lombok.Data;

@Data
public class EnggAspraintBO {
  private int htNo;
  private int rank;
  private Date dob;
  private String prefferedStreams;
  private String prefferedColleges;
  
}
