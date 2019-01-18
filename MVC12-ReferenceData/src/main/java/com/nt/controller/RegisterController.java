package com.nt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.RegisterCommand;

public class RegisterController extends SimpleFormController {

	 @Override
	public Map referenceData(HttpServletRequest req, Object command, Errors errors) throws Exception {
	     System.out.println("RegisterController.referenceData(-,-)");
		 Map<String,List<String>> map=null;
		 List<String> countriesList=null;
		 List<String> coursesList=null;
		 List<String> hobiesList=null;
		 map=new HashMap();
		 //get and add Countries dynamically
		 countriesList=new ArrayList();
		 countriesList.add("India");
		 countriesList.add("pakistan");
		 countriesList.add("China");
		 countriesList.add("japan");
		 map.put("countries",countriesList);
		//get and add courses dynamically
		 coursesList=new ArrayList();
		 coursesList.add("Java");
		 coursesList.add("C");
		 coursesList.add("Oracle");
		 coursesList.add("C++");
		 map.put("courses",coursesList);
		//get and add hobies dynamically
		 hobiesList=new ArrayList();
		 hobiesList.add("Coding");
		 hobiesList.add("Driving");
		 hobiesList.add("Slepping");
		 hobiesList.add("Watching TV");
		 map.put("hobies",hobiesList);
		 return map;
	}
	 
	 @Override
	public ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object command,
			BindException errors) throws Exception {
		 System.out.println("RegisterController.onSubmit(-,-,-,-)");
		 //return MAV
		 return new ModelAndView("result","cmdData", ((RegisterCommand)command));
	}
	
}
