package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Named;


@Named("fpkt")
public class Flipkart {
	@Inject
	//@Named("dtdc")
	private Courier courier;
	
	/*@Inject
	public  void  assign(Courier courier2){
		System.out.println("Flipkart.assign(-)");
		this.courier=courier2;
	}*/
	
   /* @Inject
	private Flipkart(Courier courier) {
		System.out.println("Flipkart.1-param constructor");
		this.courier = courier;
	}*/
    
   



	/*@Inject
	private void setCourier(Courier courier2) {
		System.out.println("Flipkart.setCourier(-)");
		this.courier = courier2;
	}*/
	

	
	public String shopping(String items[]){
		float billAmt=0.0f;
		String status=null;
		//calc billAmout
		billAmt=items.length*1000.0f;
		if(courier!=null)
		   status=courier.deliver(new Random().nextInt(10000));
		
		return Arrays.toString(items)+status+" billAmt::"+billAmt;
	}

}
