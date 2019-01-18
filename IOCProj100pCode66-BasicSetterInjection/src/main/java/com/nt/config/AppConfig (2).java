package com.nt.config;

import java.util.Calendar;
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
	
	@Bean(name="cal")
	public Calendar  createCalender() {
		System.out.println("AppConfig.createCalender()");
		return Calendar.getInstance();
	}
	

}
