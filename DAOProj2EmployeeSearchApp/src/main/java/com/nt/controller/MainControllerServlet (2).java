package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.EmployeeMgmtService;

public class MainControllerServlet extends HttpServlet {
	private EmployeeMgmtService service;
	private ApplicationContext ctx;
	@Override
	public void init() throws ServletException {
	  //create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	  //get Service class obj
		service=ctx.getBean("empService",EmployeeMgmtService.class);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String desgs[]=null;
		List<Map<String,Object>>  listDTO=null;
		RequestDispatcher rd=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		desgs=req.getParameterValues("desgs");
		//invoke service method
		listDTO=service.findEmployees(desgs);
		//keep results in request scope
		req.setAttribute("listEmps",listDTO);
		//forward request to dest comp
		rd=req.getRequestDispatcher("/show_result.jsp");
		rd.forward(req,res);
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
	
	@Override
	public void destroy() {
		service=null;
		((AbstractApplicationContext) ctx).close();
	}
}
