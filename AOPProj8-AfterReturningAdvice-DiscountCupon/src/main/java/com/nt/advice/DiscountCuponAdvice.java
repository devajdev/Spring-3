package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.AfterReturningAdvice;

public class DiscountCuponAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object retVal, Method method, Object[] args, Object target) throws Throwable {
		String cuponMsg=null;
		Writer writer=null;
		
		
		
		System.out.println("target method return value::"+retVal);
		System.out.println("Target method name::"+method.getName());
		System.out.println("Target method args::"+Arrays.deepToString(args));
		System.out.println("Target class name::"+target.getClass());
		
		
		//generate Cupon message basd bill Amount
		if(((Float)retVal)<1000)
              cuponMsg="Avail 5% discount on next Purchase";
		else if(((Float)retVal)<5000)
			  cuponMsg="Avail 10% discount on next purchase";
		else if(((Float)retVal)<10000)
			  cuponMsg="Avail 20% discount on next purchase";
		else if(((Float)retVal)<20000)
			  cuponMsg="Avail 30% discount on next purchase";
		else
			  cuponMsg="Avail 33% discount on next purchase";
		retVal=((Float)retVal)+100;
		//write cuponMessage
		writer=new FileWriter("E://cupon.txt",false);
		writer.write(cuponMsg);
		writer.flush();
		writer.close();
		throw new IllegalArgumentException("invalid");
	}//method
}//class
