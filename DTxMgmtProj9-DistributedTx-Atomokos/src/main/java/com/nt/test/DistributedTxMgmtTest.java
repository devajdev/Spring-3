package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class DistributedTxMgmtTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		boolean result=false;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy obj
		proxy=ctx.getBean("bankService",BankService.class);
		try {
			System.out.println("proxy obj class ::"+proxy.getClass());
			//invoke method
			result=proxy.transferMoney(101, 107, 2000);
			if(result)
				System.out.println("DTx Commited,Money Transfered");
			else
				System.out.println("DTx Rolledback,Money not Transfered");
		}//try
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("DTx Rolledback,Money not Transfered");
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
