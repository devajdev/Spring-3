package com.nt.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component("logAdvice")
@Aspect
@Order(3)
public class LogAroundAspect {
	Logger logger=Logger.getLogger(LogAroundAspect.class);
	
	static {
		PropertyConfigurator.configure("src/main/java/com/nt/commons/log4j.properties");
	}
	
	@Around(value="execution(* com.nt.service.BankService.*(..))")
	public Object log(ProceedingJoinPoint pjp)throws Throwable{
	    Object retVal=null;
	    Object args[]=null;
		logger.debug("Entering into "+pjp.getSignature()+"with args"+Arrays.toString(pjp.getArgs()));
		//modifying target method arg values
		args=pjp.getArgs();
		if(((Float)args[0])<=50000 )
			args[1]=((Float)args[1])-0.5f;
	     if(((Float)args[0])<=0 || ((Float)args[1])<=0 || ((Float)args[2]<=0) )
	    	 throw new IllegalArgumentException("invalid args");
	     else
		   retVal=pjp.proceed(args);
	    //modifying retur value
		retVal=((Float)retVal)+((Float)retVal)*0.01f;
	     logger.debug("Exiting from "+pjp.getSignature()+" with args"+Arrays.toString(pjp.getArgs()));
		return retVal;
	}

}
