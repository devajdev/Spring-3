package com.nt.service;

public  class IntrestAmountCalculator {
	
	public static float calcSimpleIntrAmount(float pAmt,float rate,float time) {
		System.out.println("IntrestAmountCalculator::calcSimpleIntrAmount(-,-,-)");
		return  (pAmt*rate*time)/100.0f;
	}

}
