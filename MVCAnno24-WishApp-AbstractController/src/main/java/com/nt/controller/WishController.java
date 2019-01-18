package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.WishService;

@Controller
public class WishController {
	@Autowired
	private WishService service;
	
	/*@RequestMapping("/wish.htm")
	public  ModelAndView  process() {
		String result=null;
		//use service class
		result=service.generateWishMessage();
		return new ModelAndView("result","msg", result);
	}*/
	
	/*@RequestMapping("/wish.htm")
	public  Map  process() {
		String result=null;
		Map map=null;
		//use service class
		result=service.generateWishMessage();
		map=new HashMap();
		map.put("msg",result);
		return map;
	}*/
	
	/*@RequestMapping("/wish.htm")
	public  Model  process() {
		String result=null;
		Model model=null;
		//use service class
		result=service.generateWishMessage();
		model=new ExtendedModelMap();
		model.addAttribute("msg",result);
		return model;
	}*/
	
	/*@RequestMapping("/wish.htm")
	public  ModelMap  process() {
		String result=null;
		ModelMap model=null;
		//use service class
		result=service.generateWishMessage();
		model=new ModelMap();
		model.addAttribute("msg",result);
		return model;
	}*/
	
	/*@RequestMapping("/wish.htm")
	public  String  process(ModelMap model) {
		String result=null;
		
		//use service class
		result=service.generateWishMessage();
		model.addAttribute("msg",result);
		return "result";
	}*/
	
	/*@RequestMapping("/wish.htm")
	public void  process(Model model) {
		String result=null;
		
		//use service class
		result=service.generateWishMessage();
		model.addAttribute("msg",result);
	}*/
	
	
	@RequestMapping("/wish.htm")
	public String  process(Map<String,Object> map) {
		String result=null;
		
		//use service class
		result=service.generateWishMessage();
		map.put("msg",result);
		return "result";
	}

}
