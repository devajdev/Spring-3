package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.VotingElgibilityChecker;

public class AnnoBeanLifeCycleTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		VotingElgibilityChecker checker=null,checker1=null;
		//create IOC container 
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
/*		//get Bean
		checker=ctx.getBean("voting",VotingElgibilityChecker.class);
		checker1=ctx.getBean("voting",VotingElgibilityChecker.class);
		System.out.println("checker==chercker1?"+(checker==checker1));
		System.out.println(checker.hashCode()+"  "+checker1.hashCode());

		//invoke method
		System.out.println(checker.checkElgibility());
		//close container
		((AbstractApplicationContext) ctx).close();
*/		

	}

}
