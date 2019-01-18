package com.nt.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Named("voting")
@Scope("singleton")
//@Scope("prototype")
@Lazy
public class VotingElgibilityChecker {
	@Value("raja")
	private String name;
	@Value("30")
	private int age;
	@Value("hyd")
	private String addrs;
	
	public VotingElgibilityChecker() {
	  System.out.println("VotingElgibilityChecker.VotingElgibilityChecker()");
	}

	@PostConstruct
	public void myInit(){
		System.out.println("VEC:myInit()");
		if(name==null || age<=0 || age>125)
			throw new IllegalArgumentException("set valid values for name,age properties");
	}
	

	//b.method
	public String checkElgibility(){
		if(age<18)
			return "Mr/Miss/Mrs."+name+" u r not elgible to vote";
		else
			return "Mr/Miss/Mrs."+name+" u r  elgible to vote";
	}
	
	@PreDestroy
	public  void myDestroy(){
		System.out.println("VEC:myDestroy()");
		name=null;
		age=0;
		addrs=null;
	}//method
}//class
