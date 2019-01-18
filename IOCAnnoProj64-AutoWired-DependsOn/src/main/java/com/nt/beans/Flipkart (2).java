package com.nt.beans;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component(value="fpkt")
@Component("fpkt")
public class Flipkart {
	@Autowired
	//@Qualifier("dtdc")
	private Courier courier;
	@Autowired
	private Date sysDate;
	
	public Flipkart() {
		System.out.println("Flipkart:0-param constructor");
	}
	

	
	public String shopping(String items[]){
		float billAmt=0.0f;
		String status=null;
		//calc billAmout
		billAmt=items.length*1000.0f;
		if(courier!=null)
		   status=courier.deliver(new Random().nextInt(10000))+" on date"+sysDate;
		
		return Arrays.toString(items)+status+" billAmt::"+billAmt;
	}

}
