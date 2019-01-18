package com.nt.test;

import java.io.Closeable;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.StudentService;


public class MappingSQLOperationsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		StudentService service=null;
		//create IOC container 
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service
		service=ctx.getBean("studService",StudentService.class);
		//invoke method
		try {
			System.out.println("520 details are"+service.findStudentBySno(520));
			System.out.println(".............");
			System.out.println("hyd,vizag city students details are::"+service.findStudentsByAddrs("hyd","vizag"));
			System.out.println("..............");
			System.out.println(service.changeStudentAddressBySno(520, "new delhi"));
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
