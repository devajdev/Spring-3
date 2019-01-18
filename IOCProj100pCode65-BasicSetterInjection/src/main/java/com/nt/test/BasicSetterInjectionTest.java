package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

public class BasicSetterInjectionTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=null;
		WishMessageGenerator generator=null;
		//create IOC container
		ctx=new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		/*//get Target bean class obj
		generator=ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke method
		System.out.println("Wish Message ::"+generator.generateWishMsg("raja"));*/
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
