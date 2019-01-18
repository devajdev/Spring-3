package com.nt.postprocessor;

import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.nt.bo.BaseBO;

public class BOPostProcessor implements BeanPostProcessor {
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BOPostProcessor.postProcessBeforeInitialization(-,-)");
		if(bean instanceof BaseBO){
			System.out.println("BaseBO initialialization");
			((BaseBO)bean).setDoj(new Date());
		}
	return bean;	
		
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BOPostProcessor.postProcessAfterInitialization(-,-)");
	  return bean;
	}

}
