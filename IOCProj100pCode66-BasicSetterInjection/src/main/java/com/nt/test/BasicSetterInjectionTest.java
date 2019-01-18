package com.nt.test;

import java.util.Calendar;

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
		//get Target bean class obj
		generator=ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke method
		System.out.println("Wish Message ::"+generator.generateWishMsg("raja"));
		System.out.println("..................");
		System.out.println(ctx.getBean("createCalender",Calendar.class));
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
