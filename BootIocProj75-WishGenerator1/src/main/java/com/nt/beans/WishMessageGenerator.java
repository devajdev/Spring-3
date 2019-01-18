package com.nt.beans;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	@Autowired
	private Calendar cal;
	
	public String generateWishMessage(String uname) {
		int hour=0;
		//get Current hour of the day
		hour=cal.get(Calendar.HOUR_OF_DAY); //24 hrs 
		//generate wish Message
		if(hour<=12)
			return "Good Morning:"+uname;
		else if(hour<=16)
			return "Good AfterNoon:"+uname;
		else if(hour<=20)
			return "Good Evening:"+uname;
		else
			return "Good Night :"+uname;
	}//method
}//class
