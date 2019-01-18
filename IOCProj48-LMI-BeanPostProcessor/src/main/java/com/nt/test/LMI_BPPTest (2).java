package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.CollegeService;

public class LMI_BPPTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CollegeService service=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class object
		service=ctx.getBean("clgService",CollegeService.class);
		//invoke b.methods
		System.out.println(".......................");
		service.registerEmployee(101,"raja","CLERK");
		System.out.println("________________________");
		service.registerEmployee(102,"rani","CLERK");
		System.out.println("===========================");
		service.registerStudent(1001,"pratyush","java");
		System.out.println("________________________");
		service.registerStudent(1002,"mahesh",".net");
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
