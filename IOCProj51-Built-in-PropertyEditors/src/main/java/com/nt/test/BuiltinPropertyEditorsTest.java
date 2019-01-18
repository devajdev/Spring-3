package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.AadharDetails;

public class BuiltinPropertyEditorsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AadharDetails details=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		details=ctx.getBean("aadhar",AadharDetails.class);
		System.out.println(details);
		
		//close stream
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
