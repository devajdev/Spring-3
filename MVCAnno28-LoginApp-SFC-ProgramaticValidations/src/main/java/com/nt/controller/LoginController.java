package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginService;
import com.nt.validator.LoginValidator;

@Controller
public class LoginController {
	@Autowired
	private LoginService service;
	
	@Autowired
	private LoginValidator validator;
	
	
	//@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	@GetMapping("/login.htm")
	public String  showForm(@ModelAttribute("userCmd")UserCommand cmd) {
		return "login_form";
	}
	
	//@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	@PostMapping("/login.htm")
	public String processForm(Map<String,Object> map,@ModelAttribute("userCmd")UserCommand cmd,BindingResult errors) {
		UserDTO dto=null;
		String result=null;
		if(validator.supports(cmd.getClass())) {
			validator.validate(cmd, errors);
			
			if(errors.hasErrors())
				return "login_form";
			
		}
		//convert Command obj to DTO
		dto=new UserDTO();
		BeanUtils.copyProperties(cmd,dto);
		//use service
		result=service.authenticate(dto);
		//put data in Model Attribute
		map.put("result",result);
		return "login_form";
		
	}

}
