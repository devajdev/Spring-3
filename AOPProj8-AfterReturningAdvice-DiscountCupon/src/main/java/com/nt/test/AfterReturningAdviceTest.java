package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ShoppingStore;

public class AfterReturningAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ShoppingStore proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		proxy=ctx.getBean("pfb",ShoppingStore.class);
		//invoke method
		System.out.println("Bill Amount::"+proxy.shopping(new String[] {"garba dress","dandiya sticks","rold gold","sweets"}));
		//close container
		((AbstractApplicationContext) ctx).close();
		Class c=String[].class;
		System.out.println("c obj data"+c);
	}//main
}//class
