package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("wmg")
//@Scope("prototype")
@Lazy
public class WishMessageGenerator {
	@Autowired
	private Date date;
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator.WishMessageGenerator()");
	}
	
	public  String generateWishMsg(String uname) {
		int hour=0;
		//get current hour of the day
		hour=date.getHours();
		if(hour<12)
			return "GM:"+uname;
		else if(hour<16)
			return "GA:"+uname;
		else if(hour<20)
			return "GE:"+uname;
		else 
			return "GN:"+uname;
	}

}
