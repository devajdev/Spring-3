package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("iac")
public class IntrAmountCalculator {
	@Value("10000,12,2")
	private AmountDetails details;
	
	
	/*public IntrAmountCalculator(AmountDetails details) {
		this.details = details;
	}*/


	public float calcIntrAmount(){
		return  (details.getpAmt()*details.getRate()*details.getTime())/100.0f;
	}

}
