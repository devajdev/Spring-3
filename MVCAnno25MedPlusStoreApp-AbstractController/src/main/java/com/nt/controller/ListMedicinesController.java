package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.MedicineDetailsDTO;
import com.nt.service.MedicineService;

//@RestController
@Controller
public class ListMedicinesController  {
	@Autowired
	private MedicineService service;
	

	@RequestMapping("/med.htm")
	public String handle(Map<String,Object> map)
			throws Exception {
		List<MedicineDetailsDTO> listDTO=null;
		//use SErvice
		listDTO=service.fetchAllMedicines();
		map.put("listMed", listDTO);
		return "show_report";
	}

}
