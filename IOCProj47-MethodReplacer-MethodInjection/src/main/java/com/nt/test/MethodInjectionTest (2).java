package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.BankService;

public class MethodInjectionTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService service=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean 
		service=ctx.getBean("bankService",BankService.class);
		System.out.println("obj class::"+service.getClass());
		//invoke the methods
		System.out.println("Simple Intr Amount:"+service.calcSimpleIntrAmount(10000,12));
		System.out.println("......................");
		System.out.println("Compound Intr Amount:"+service.calcCompoundIntrAmount(10000,12));
		
		//close IOC container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
