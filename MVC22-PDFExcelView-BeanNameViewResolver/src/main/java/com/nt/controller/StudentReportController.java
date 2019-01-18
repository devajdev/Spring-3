package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.StudentDTO;

public class StudentReportController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		StudentDTO dto1=null,dto2=null,dto3=null;
		List<StudentDTO> listDTO=null;
		//construct Model Data
		dto1=new StudentDTO();
		dto1.setSno(101); dto1.setSname("raja"); dto1.setSadd("hyd");
		dto2=new StudentDTO();
		dto2.setSno(102); dto2.setSname("ravi"); dto2.setSadd("vizag");
		dto3=new StudentDTO();
		dto3.setSno(103); dto3.setSname("ramesh"); dto3.setSadd("vizag");
		listDTO=new ArrayList();
		listDTO.add(dto1); listDTO.add(dto2);
		listDTO.add(dto3);
		//return MAVC object
		if(req.getParameter("type").equalsIgnoreCase("pdf")) {
			return new ModelAndView("pdfView","listDTO",listDTO);
		}
		else {
			return new ModelAndView("xlsView","listDTO",listDTO);
		}
	}

}
