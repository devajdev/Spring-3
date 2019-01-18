package com.nt.config;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan(basePackages="com.nt.beans")
public class AppConfig {
	
	public AppConfig() {
		System.out.println("AppConfig.AppConfig()");
	}
	
	@Bean(name="dt")
	//@Scope("prototype")
	@Lazy
	public  Date  createDate() {
		System.out.println("AppConfig.createDate()");
    	return new Date();
	}
	
	

}
