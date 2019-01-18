package com.nt.service;

import java.util.Calendar;

public class LoanApprover {
	private String name;
	
	public LoanApprover(String name) {
		this.name = name;
	}

	public String approveLoan(int loanId,float amount,String loanType) {
		Calendar cal=null;
		int month=0;
		//get System Date
		cal=Calendar.getInstance();
		//get current hour of the day
		month=cal.get(Calendar.MONTH);
		if(month>=6 && month<=9 && loanType.equalsIgnoreCase("agriculture") && amount<=200000)
			return name+" manager has approved loan amount of "+amount+" for the loan id "+loanId+" of loan type "+loanType;
		else 
			return name+" manager has rejected loan amount of "+amount+" for the loan id "+loanId+" of loan type "+loanType;
	}

}
