package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IntrestAmountCalculator;
import com.nt.service.IntrestAmountCalculatorImpl;

public class AroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IntrestAmountCalculator proxy=null;
		//create IOC contianer
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy  object
		proxy=ctx.getBean("pfb",IntrestAmountCalculator.class);
		
		//invoke b.method
		System.out.println("Intrest Amount1(simple):::"+proxy.calcSimpleIntrAmount(100000,2, 12));
		System.out.println("proxy obj class name::"+proxy.getClass());
		 Class inters[]=proxy.getClass().getInterfaces();
		 for(Class inter:inters) {
			 System.out.println(inter.getName());
		 }
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
