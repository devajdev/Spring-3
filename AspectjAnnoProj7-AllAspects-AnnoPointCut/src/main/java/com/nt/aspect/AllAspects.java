package com.nt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("allAspects")
@Aspect
public class AllAspects {
	
	@Pointcut(value="execution(* com.nt.service.AirthmeticService.*(..))")
	public void myPtc() {
		
	}
	
	@Around(value="myPtc()")
	public Object logAround(ProceedingJoinPoint pjp)throws Throwable{
		Object retVal=null;
		System.out.println("around advice:: before entering into "+pjp.getSignature());
		retVal=pjp.proceed();
		System.out.println("around advice:: exiting from "+pjp.getSignature());
		return retVal;
	}
	
	@Before(value="myPtc()")
	public  void  logBefore(JoinPoint jp)throws Throwable{
		System.out.println("before advice:: before entering into "+jp.getSignature());
	}
	
	@AfterReturning(value="myPtc()",returning="result")
	public  void  logAfter(JoinPoint jp,float result) {
		System.out.println("after advice:: before exiting from "+jp.getSignature());
	}
	
	@AfterThrowing(value="myPtc()",throwing="ex")
	public  void  logException(JoinPoint jp,Exception ex) {
		System.out.println("Throws advice:: exception is in "+jp.getSignature());
	}
	
	

}
