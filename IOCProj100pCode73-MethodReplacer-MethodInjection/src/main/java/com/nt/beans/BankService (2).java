package com.nt.beans;

public  class BankService {
	
	public  float calcSimpleIntrAmount(float pAmt,float time){
		System.out.println("BankService:calcSimpleIntrAmount(-,-,-)");
	  return  (pAmt*time*2.0f)/100.0f;	
	}
	
	public   float calcCompoundIntrAmount(float pAmt,float time){
		System.out.println("BankService:calcCompoundIntrAmount(-,-,-)");
	  return  (float) (pAmt*Math.pow((1+ (2.0f/100)),time))-pAmt;
	}
	
	

}
