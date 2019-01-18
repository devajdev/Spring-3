package com.nt.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WishMessageGeneratorController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Calendar cal=null;
		int hour=0;
		String wMsg=null;
		ModelAndView mav=null;
		//write b.logic/req processing logic
		cal=Calendar.getInstance();
		//get current hour of the day
		hour=cal.get(Calendar.HOUR_OF_DAY);
		//generate wish Message
		if(hour<12)
			wMsg="Good Morning";
		else if(hour<16)
			wMsg="Good AfterNoon";
		else if(hour<20)
			wMsg="Good Evening";
		else
			wMsg="Good Night";
		//create MAV object
		mav=new ModelAndView();
		mav.setViewName("result");
		mav.addObject("msg",wMsg);
		return mav;
	}

}
