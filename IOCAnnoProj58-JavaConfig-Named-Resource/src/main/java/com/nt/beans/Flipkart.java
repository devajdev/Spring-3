package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

import javax.annotation.Resource;
import javax.inject.Named;


@Named("fpkt")
public class Flipkart {
	
	//@Resource(name="blueDart")
	private Courier courier;
	
	/*@Resource(name="blueDart")
	public  void  assign(Courier courier2){
		System.out.println("Flipkart.assign(-)");
		this.courier=courier2;
	}*/
	
    //@Resource(name="dtdc") --@Resource is disallowed here
	private Flipkart(Courier courier) {
		System.out.println("Flipkart.1-param constructor");
		this.courier = courier;
	}
    
   



	/*@Resource(name="dtdc")
	private void setCourier(Courier courier) {
		System.out.println("Flipkart.setCourier(-)");
		this.courier = courier;
	}
	*/

	
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
