package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.nt.command.EmployeeCommand;
import com.nt.dto.EmployeeInputDTO;
import com.nt.dto.EmployeeResultDTO;
import com.nt.service.EmployeeSearchService;

@Controller
public class EmployeeSearchController {
	@Autowired
   private EmployeeSearchService service;
   

    @RequestMapping("/search.htm")
	public String processSearch(Map<String,Object>map,@ModelAttribute("searchCmd")EmployeeCommand cmd) throws Exception {
	  EmployeeInputDTO idto=null;	
	  List<EmployeeResultDTO> listRDTO=null;
	 //convert command to IDTO
	  idto=new EmployeeInputDTO();
	  BeanUtils.copyProperties(cmd,idto);
	 //use Service
	  listRDTO=service.findEmployees(idto);
	  //put results in Map collection
	  map.put("listRDTO",listRDTO);
	  return "show_emps";
    }//method
}//class
