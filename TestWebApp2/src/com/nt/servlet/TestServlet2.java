package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.singleton.PrinterUtil;


@WebServlet("/testurl1")
public class TestServlet2 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		PrinterUtil pu1=null,pu=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		try{
		pu1=PrinterUtil.getInstance();
		pu=PrinterUtil.getInstance();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		pw.println("<h1 style='color:red'> pu1 hashCode::"+pu1.hashCode()+" pu:"+pu.hashCode());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
