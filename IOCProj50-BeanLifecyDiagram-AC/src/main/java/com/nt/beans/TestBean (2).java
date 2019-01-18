package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class TestBean implements BeanFactoryAware,ApplicationContextAware,BeanNameAware,InitializingBean,DisposableBean {
    private String name;
   
	private int age;
	
	public TestBean(String name) {
		System.out.println("TestBean:1-param constructor");
		this.name=name;
	}
	
	 public void setAge(int age) {
		 System.out.println("TestBean:setAge(-)");
			this.age = age;
		}

	
	@Override
	public void setBeanName(String beanName) {
		System.out.println("TestBean:setBeanName(-)");
		
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("TestBean.setApplicationContext(-)");
		
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("TestBean.setBeanFactory(-)");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("TestBean.destroy()");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("TestBean.afterPropertiesSet()");
		
	}
	
	public void myInit(){
		System.out.println("TestBean:myInit()");
	}
	
	public void myDestroy(){
		System.out.println("TestBean:myDestroy()");
	}
	
	public String sayHello(String user){
		return "Good Morning:"+user;
	}

}
