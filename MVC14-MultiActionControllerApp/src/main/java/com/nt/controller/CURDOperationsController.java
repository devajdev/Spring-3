package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.nt.command.UserCommand;

public class CURDOperationsController extends MultiActionController {

	public  ModelAndView insert(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		return new ModelAndView("user","operation","insert");
	}
	
	public  ModelAndView update(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		return new ModelAndView("user","operation","update");
	}
	
	public  ModelAndView delete(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		return new ModelAndView("user","operation","delete");
	}
	
	public  ModelAndView view(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		return new ModelAndView("user","operation","view");
	}
	
	public  ModelAndView invalid(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		return new ModelAndView("user","operation","invalid");
	}
}
