package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Flipkart;

public class Inject_Named_AnnoTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Flipkart fpkt=null;
		//create IOC Conntainer
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		fpkt=ctx.getBean("fpkt",Flipkart.class);
		System.out.println(fpkt.shopping(new String[]{"bakra","patani","attar","shurma"}));
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
