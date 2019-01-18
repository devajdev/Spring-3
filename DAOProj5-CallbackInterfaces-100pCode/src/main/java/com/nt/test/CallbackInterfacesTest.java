package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

public class CallbackInterfacesTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		EmployeeDTO dto=null;
		List<EmployeeDTO> listDTO=null;
		//create IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Bean
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		try {
		//invoke methods
		dto=service.findEmployeeByNo(7499);
		System.out.println("7499 Emp details are"+dto);
		System.out.println("........................");
		listDTO=service.findEmployeesByDesgs("CLERK","MANAGER","SALESMAN");
		System.out.println("Employee Details whose desgs are CLERK,MAMNAGER,SALESMAN");
		listDTO.forEach(dto1->{
			System.out.println(dto1);
		});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
