package com.nt.test;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IntrestAmountCalculator;

public class AroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IntrestAmountCalculator proxy=null,target=null;
		//create IOC contianer
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy  object
		proxy=ctx.getBean("pfb",IntrestAmountCalculator.class);
		
		//invoke b.method
		System.out.println("Intrest Amount1(simple):::"+proxy.calcSimpleIntrAmount(100000,2, 12));
		System.out.println("..................");
		System.out.println("Intrest Amount2(simple):::"+proxy.calcSimpleIntrAmount(0,2, 12));			
			
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
