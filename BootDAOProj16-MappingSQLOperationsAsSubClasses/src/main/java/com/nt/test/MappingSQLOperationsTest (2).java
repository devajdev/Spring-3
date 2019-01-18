package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.StudentService;



@SpringBootApplication
@Import(AppConfig.class)
public class MappingSQLOperationsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		StudentService service=null;
		//get IOC container 
		ctx=SpringApplication.run(MappingSQLOperationsTest.class, args);
		//get Service
		service=ctx.getBean("studService",StudentService.class);
		//invoke method
		try {
			System.out.println("520 details are"+service.findStudentBySno(520));
			System.out.println(".............");
			System.out.println("hyd,vizag city students details are::"+service.findStudentsByAddrs("hyd","vizag"));
			System.out.println("..............");
			System.out.println(service.changeStudentAddressBySno(520, "new delhi"));
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
