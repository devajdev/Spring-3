package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Flipkart {
	//@Autowired(required=false)
	@Autowired
	//@Qualifier("courier1")
	private Courier courier;
	
	/*@Autowired
	public  void  assign(Courier courier2){
		System.out.println("Flipkart.assign(-)");
		this.courier=courier2;
	}*/
	
   /* @Autowired
	private Flipkart(Courier courier) {
		System.out.println("Flipkart.1-param constructor");
		this.courier = courier;
	}*/
    
   



	/*@Autowired
	//@Qualifier("courier1")
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
