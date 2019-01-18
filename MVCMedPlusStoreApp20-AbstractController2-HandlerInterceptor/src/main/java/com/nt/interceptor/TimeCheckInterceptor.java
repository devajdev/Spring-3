package com.nt.interceptor;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimeCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar cal=null;
		int hour=0;
		RequestDispatcher rd=null;
		//get System Date and time
		cal=Calendar.getInstance();
		//get current hour of the day
		hour=cal.get(Calendar.HOUR_OF_DAY);
		if(hour<9 || hour>17) {
			rd=request.getRequestDispatcher("/timeout.jsp");
			rd.forward(request,response);
			return false;
		}
		else {
			return true;
		}
			
		
	}
	
}
