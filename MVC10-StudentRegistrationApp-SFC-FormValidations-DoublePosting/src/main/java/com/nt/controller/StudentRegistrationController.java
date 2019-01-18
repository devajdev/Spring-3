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
			BindException err1) throws Exception {
		String resultMsg=null;
		StudentDTO dto=null;
		//application logic errors
		if(((StudentCommand)command).getCourse().equalsIgnoreCase(".net")) {
			err1.rejectValue("course","course.rejected");
			return showForm(request,response, err1);
		}
			

		//convert Command class obj to DTO
		dto=new StudentDTO();
		BeanUtils.copyProperties(((StudentCommand)command), dto);
		//use service
		resultMsg=service.register(dto);
		//return MAV
		return new ModelAndView("result","msg",resultMsg);
	}
	
	@Override
	public ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("StudentRegistrationController::handleInvalidSubmit(-,-)");
		return new ModelAndView("dbl_post");
	}
	
	@Override
	public Object formBackingObject(HttpServletRequest request) throws Exception {
		System.out.println("StudentRegistrationController.formBackingObject(-)");
	    StudentCommand st=null;
	    st=new StudentCommand();
	    st.setSadd("delhi");
	    st.setCourse("java");
	    return st;
	}
	
}
