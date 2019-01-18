package com.nt.test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

@SpringBootApplication
@Import(value=AppConfig.class)
public class BootIocProj75WishGeneratorApplication1 {
	
	
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		WishMessageGenerator generator=null;
		//get Access to IOC container
		ctx=SpringApplication.run(BootIocProj75WishGeneratorApplication1.class, args);
		//get Target Bean class object
		generator=ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke the method
		System.out.println("Result===>"+generator.generateWishMessage("raja"));
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}
}
