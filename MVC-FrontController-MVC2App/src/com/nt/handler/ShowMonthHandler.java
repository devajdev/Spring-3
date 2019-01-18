package com.nt.handler;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowMonthHandler implements Handler {
	
	public String  handle(HttpServletRequest req,HttpServletResponse res)throws Exception{
		Calendar cal=null;
		int month=0;
		//get System Date
		cal=Calendar.getInstance();
		month=cal.get(Calendar.MONTH)+1;
		//keep result in request scope
		req.setAttribute("resultData",month);
		return "show_month";
		
	}

}
