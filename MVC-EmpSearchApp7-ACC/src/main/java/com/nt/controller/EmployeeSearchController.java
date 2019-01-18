package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.nt.command.EmployeeCommand;
import com.nt.dto.EmployeeInputDTO;
import com.nt.dto.EmployeeResultDTO;
import com.nt.service.EmployeeSearchService;

public class EmployeeSearchController extends AbstractCommandController {
   private EmployeeSearchService service;
   
public EmployeeSearchController(EmployeeSearchService service) {
	System.out.println("EmployeeSearchController::1-param constructor");
	this.service = service;
}

@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
	  EmployeeInputDTO idto=null;	
	  List<EmployeeResultDTO> listRDTO=null;
	 //convert command to IDTO
	  idto=new EmployeeInputDTO();
	  BeanUtils.copyProperties(((EmployeeCommand)command),idto);
	 //use Service
	  listRDTO=service.findEmployees(idto);
	  //return MAV object
		return new ModelAndView("show_emps","listRDTO",listRDTO);
	}

}
