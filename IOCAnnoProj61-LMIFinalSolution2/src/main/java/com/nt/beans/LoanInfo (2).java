package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("loanInfo")
public class LoanInfo {
	@Value("9001")
    private int loanId;
	@Value("rakesh")
	private String custName;
	@Value("90000")
    private float amount;
    
   
    
    
    public int getLoanId() {
		return loanId;
	}

	public String getCustName() {
		return custName;
	}

	public float getAmount() {
		return amount;
	}

	
    
}
