package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

public class NamedParameterJdbcTemplateTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		List<EmployeeDTO> listDTO=null;
		EmployeeDTO myDTO=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		try {
			listDTO=service.fetchEmployeesBySalaryRange(1000, 2000);
			listDTO.forEach(dto->{
				System.out.println(dto);
			});
			System.out.println("................");
			myDTO=new EmployeeDTO();
			myDTO.setEno(9002);
			myDTO.setEname("ramesh");
			myDTO.setSalary(7000);
			myDTO.setDesg("CLERK");
			System.out.println(service.registerEmp(myDTO));
			
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
