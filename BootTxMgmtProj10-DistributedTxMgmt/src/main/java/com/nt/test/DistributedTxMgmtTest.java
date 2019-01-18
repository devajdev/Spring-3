package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;

@SpringBootApplication
@Import(AppConfig.class)
public class DistributedTxMgmtTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		boolean result=false;
		//create IOC container
		ctx=SpringApplication.run(DistributedTxMgmtTest.class,args);
				
		//get Proxy obj
		proxy=ctx.getBean("bankService",BankService.class);
		try {
			System.out.println("proxy obj class ::"+proxy.getClass());
			//invoke method
			result=proxy.transferMoney(101, 102, 2000);
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
