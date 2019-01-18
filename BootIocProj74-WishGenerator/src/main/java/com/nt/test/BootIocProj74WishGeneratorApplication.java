package com.nt.test;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootIocProj74WishGeneratorApplication {
	
	@Bean
	public Calendar createCalendar() {
		return Calendar.getInstance();
	}

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		WishMessageGenerator generator=null;
		//get Access to IOC container
		ctx=SpringApplication.run(BootIocProj74WishGeneratorApplication.class, args);
		//get Target Bean class object
		generator=ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke the method
		System.out.println("Result===>"+generator.generateWishMessage("raja"));
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}
}
