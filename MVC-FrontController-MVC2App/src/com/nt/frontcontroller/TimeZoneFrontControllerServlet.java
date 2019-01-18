package com.nt.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.handler.Handler;
import com.nt.handler.ShowMonthHandler;
import com.nt.handler.ShowYearHandler;

public class TimeZoneFrontControllerServlet extends HttpServlet {
	
   @Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   String path=null;
	   Handler handler=null;
	   String lvn=null;
	   String resultPage=null;
	   RequestDispatcher rd=null;
	   //get Virtual of request url
	   path=req.getServletPath();
	   //Navigation management
	   if(path.equalsIgnoreCase("/link1.do")) {
		   handler=new ShowMonthHandler();
	   }
	   else if(path.equalsIgnoreCase("/link2.do")) {
		   handler=new ShowYearHandler();
	   }
	   try {
	   //invoke handler method
	   lvn=handler.handle(req, res);
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   //View management
	   if(lvn.equals("show_month"))
		   resultPage="/"+lvn+".jsp";
	   else if(lvn.equals("show_year"))
		   resultPage="/"+lvn+".jsp";
	   rd=req.getRequestDispatcher(resultPage);
	   rd.forward(req, res);
   }
   
   @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          doGet(req,res);	
	}
   
	

}
