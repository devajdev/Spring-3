package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.StudentCommand;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class StudentRegistrationController extends SimpleFormController {
	private StudentService service;

	public StudentRegistrationController(StudentService service) {
	System.out.println("StudentRegistrationController:1-param constructor");
		this.service = service;
	}

	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		String resultMsg=null;
		StudentDTO dto=null;
		//convert Command class obj to DTO
		dto=new StudentDTO();
		BeanUtils.copyProperties(((StudentCommand)command), dto);
		//use service
		resultMsg=service.register(dto);
		//return MAV
		return new ModelAndView("result","msg",resultMsg);
	}
}
