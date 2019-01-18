package com.nt.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nt.service.BankService;

@Configuration
@ComponentScan(basePackages="com.nt.advice")
public class AOPConfig {
	@Autowired
	private BankService service;
	
	@Bean(name="pfb")
	public  ProxyFactoryBean createPFB() {
		ProxyFactoryBean pfb=null;
		pfb=new ProxyFactoryBean();
		pfb.setTarget(service);
		pfb.setInterceptorNames("securityAdvice");
		return pfb;
	}
	

}
