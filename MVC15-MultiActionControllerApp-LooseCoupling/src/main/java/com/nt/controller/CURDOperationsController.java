package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.nt.command.UserCommand;

public class CURDOperationsController extends MultiActionController {

	public  ModelAndView insert(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		ModelAndView mav=null;
		//create and return MAV object
		mav=new ModelAndView();
		mav.setViewName("user");
		mav.addObject("operation","insert");
		mav.addObject("cmdData",cmd);
		return mav;
	}
	
	public  ModelAndView update(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		ModelAndView mav=null;
		mav=new ModelAndView();
		mav.setViewName("user");
		mav.addObject("operation","update");
		mav.addObject("cmdData",cmd);
		return mav;

	}
	
	public  ModelAndView delete(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		ModelAndView mav=null;
		mav=new ModelAndView();
		mav.setViewName("user");
		mav.addObject("operation","delete");
		mav.addObject("cmdData",cmd);
		return mav;

	}
	
	public  ModelAndView view(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		ModelAndView mav=null;
		mav=new ModelAndView();
		mav.setViewName("user");
		mav.addObject("operation","view");
		mav.addObject("cmdData",cmd);
		return mav;
	}
	
	public  ModelAndView invalid(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		ModelAndView mav=null;
		mav=new ModelAndView();
		mav.setViewName("user");
		mav.addObject("operation","invalid");
		mav.addObject("cmdData",cmd);
		return mav;
	}
}
