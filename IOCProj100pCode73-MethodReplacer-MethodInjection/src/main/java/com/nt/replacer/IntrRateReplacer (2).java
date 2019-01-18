package com.nt.replacer;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;

@Component("intrReplacer")
public class IntrRateReplacer implements MethodReplacer {
    @Value("1.5f")
	private float rate=1.0f;

	
	@Override
	public Object reimplement(Object object, Method method, Object[] args) throws Throwable {
		float pAmt = 0.0f, time = 0.0f;
		System.out.println("IntrRateReplacer:reimplement(-,-,-)");
		System.out.println("target class name::" + object.getClass());
		System.out.println("target method name::" + method.getName());
		System.out.println("target method args::" + Arrays.toString(args));
		// get target method args
		pAmt = (Float) args[0];
		time = (Float) args[1];
		//calc Intrest amount
		return (pAmt*time*rate)/100.0f;
	}

}
