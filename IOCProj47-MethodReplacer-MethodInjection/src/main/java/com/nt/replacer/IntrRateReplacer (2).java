package com.nt.replacer;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.beans.factory.support.MethodReplacer;

public class IntrRateReplacer implements MethodReplacer {

	private float rate=1.0f;

	public void setRate(float rate) {
		this.rate = rate;
	}

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
