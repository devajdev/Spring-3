package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.nt.postprocessor.BOPostProcessor;
import com.nt.service.CollegeService;

public class LMI_BPPTestWithBeanFactory {

	public static void main(String[] args) {
		BeanFactory factory=null;
		CollegeService service=null;
		BOPostProcessor processor=null;
		//create IOC container
		factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		//create BeanPostProcessor class obj
		processor=new BOPostProcessor();
		((ConfigurableListableBeanFactory)factory).addBeanPostProcessor(processor);
		
		//get Service class object
		service=factory.getBean("clgService",CollegeService.class);
		//invoke b.methods
		System.out.println(".......................");
		service.registerEmployee(101,"raja","CLERK");
		System.out.println("________________________");
		service.registerEmployee(102,"rani","CLERK");
		System.out.println("===========================");
		service.registerStudent(1001,"pratyush","java");
		System.out.println("________________________");
		service.registerStudent(1002,"mahesh",".net");
		
	}//main
}//class
