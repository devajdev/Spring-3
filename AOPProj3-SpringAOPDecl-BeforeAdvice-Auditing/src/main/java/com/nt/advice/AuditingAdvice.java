package com.nt.advice;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.springframework.aop.MethodBeforeAdvice;

public class AuditingAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String auditMsg=null;
		FileWriter writer=null;
		System.out.println("target method name::"+method.getName());
		System.out.println("target method args::"+Arrays.toString(args));
		System.out.println("target class name::"+target.getClass());
		//acceessing and modifying target method arg value
		
		args[1]=((Float)args[1])+10000;
		 //prepare Audit Message
		auditMsg="loanId "+args[0]+" loan has come for approval for amount "+args[1]+" of type "+args[2]+" at "+new Date()+"\n";
		
		//write Audit message to Audit Log file
		writer=new FileWriter("E:\\auditLog.txt",true);
		writer.write(auditMsg);
		writer.flush();
		writer.close();
		throw new IllegalArgumentException();
	}//method
}//class
