package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("amtDetails")
public class AmountDetails {
	private int pAmt;
	private int rate;
	private int time;
	
	public AmountDetails(int pAmt, int rate, int time) {
		System.out.println("AmountDetails:3-param constructor");
		this.pAmt = pAmt;
		this.rate = rate;
		this.time = time;
	}


	public int getpAmt() {
		return pAmt;
	}

	public int getRate() {
		return rate;
	}

	public int getTime() {
		return time;
	}

	
	

}
