package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.AirthmeticService;



public class AllAspectJAroundTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AirthmeticService proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		proxy=ctx.getBean("airthService",AirthmeticService.class);
		//invoke the methods
		System.out.println("sum =="+proxy.sum(100,200));
		System.out.println("...............");
		System.out.println("sub =="+proxy.sub(100,200));
		System.out.println("...............");
		System.out.println("mul =="+proxy.mul(100,200));
		System.out.println("...............");
		System.out.println("div =="+proxy.div(100,20));
		System.out.println(".........");
		System.out.println("div1 =="+proxy.div(0,0));
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
