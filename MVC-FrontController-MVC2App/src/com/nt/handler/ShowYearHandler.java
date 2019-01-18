package com.nt.handler;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowYearHandler implements Handler {
	
	public String  handle(HttpServletRequest req,HttpServletResponse res)throws Exception{
		Calendar cal=null;
		int year=0;
		//get System Date
		cal=Calendar.getInstance();
		year=cal.get(Calendar.YEAR);
		//keep result in request scope
		req.setAttribute("resultData",year);
		return "show_year";  //lvn
		
	}

}
