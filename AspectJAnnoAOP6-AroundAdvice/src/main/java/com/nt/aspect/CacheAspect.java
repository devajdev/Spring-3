package com.nt.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component("cacheAspect")
@Order(1)
public class CacheAspect {
	private Map<String,Object> cache=new HashMap();
	
	@Around(value="execution(* com.nt.service.BankService.*(..))")
	public  Object caching(ProceedingJoinPoint pjp)throws Throwable {
	  Object retVal=null;	
		String key=pjp.getSignature()+Arrays.toString(pjp.getArgs());
		if(!cache.containsKey(key)) {
			System.out.println("from taget method");
			retVal=pjp.proceed();
			cache.put(key,retVal);
			return retVal;
		}
		retVal=cache.get(key);
		System.out.println("from cache");
		return retVal;
	}

}
