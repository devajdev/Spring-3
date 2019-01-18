package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService service;
	
	
	//@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	@GetMapping("/login.htm")
	public String  showForm(@ModelAttribute("userCmd")UserCommand cmd) {
		return "login_form";
	}
	
	//@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	@PostMapping("/login.htm")
	public String processForm(Map<String,Object> map,@Valid @ModelAttribute("userCmd")UserCommand cmd,BindingResult errors) {
		UserDTO dto=null;
		String result=null;
		if(errors.hasErrors())
			return "login_form";
		
		//Applicaiton logic errors
		if(cmd.getUsername().equalsIgnoreCase("raja")) {
			errors.rejectValue("username","user.blocked");
			return "login_form";
		}
			
		
		//convert Command obj to DTO
		dto=new UserDTO();
		BeanUtils.copyProperties(cmd,dto);
		//use service
		result=service.authenticate(dto);
		
		//put data in Model Attribute
		map.put("result",result);
		map.put("cmdData",cmd);
		return "login_form";
	}
	
	@ModelAttribute("dynaDomains")
	public  List<String> populateDomains(){
		System.out.println("LoginController.populateDomains()");
		List<String> dmnsList=new ArrayList();
		dmnsList.add("gmail");dmnsList.add("yahoo");
		dmnsList.add("hotmail");
		return dmnsList;
	}
	
	
	@ModelAttribute("dynaLanguages")
	public  List<String> populateLanguages(){
		System.out.println("LoginController.populateLanguages()");
		List<String> langList=new ArrayList();
		langList.add("english");langList.add("hindi");
		langList.add("telugu");
		return langList;
	}
	
	@InitBinder
	public  void binder(WebDataBinder binder) {
		System.out.println("LoginController.binder()");
		SimpleDateFormat sdf=null;
		sdf=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
		
	}

	
	

}
