package com.nt.test;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.postprocessor.BOPostProcessor;
import com.nt.service.CollegeService;

public class LMI_BPPTestWithBeanFactory1 {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		CollegeService service=null;
		BOPostProcessor processor=null;
		XmlBeanDefinitionReader reader=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
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
