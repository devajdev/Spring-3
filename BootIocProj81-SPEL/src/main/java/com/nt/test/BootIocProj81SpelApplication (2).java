package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.beans.AmoghaBillCounter;
import com.nt.config.AppConfig;

@SpringBootApplication
@Import(value=AppConfig.class)
public class BootIocProj81SpelApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AmoghaBillCounter counter=null;
		ctx=SpringApplication.run(BootIocProj81SpelApplication.class, args);
		//get Target Bean class obj
		counter=ctx.getBean("agCounter",AmoghaBillCounter.class);
		System.out.println(counter);
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}
}
