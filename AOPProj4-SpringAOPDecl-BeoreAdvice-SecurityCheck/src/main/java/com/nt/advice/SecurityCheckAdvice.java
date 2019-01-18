package com.nt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.nt.manager.AuthenticationManager;

public class SecurityCheckAdvice implements MethodBeforeAdvice {
	private AuthenticationManager manager;

	public SecurityCheckAdvice(AuthenticationManager manager) {
		this.manager = manager;
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
       //perform Authentication
		if(!manager.validate())
			throw new IllegalArgumentException("Invalic Credentials");

	}

}
