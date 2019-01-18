package com.nt.test;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

@SpringBootApplication
@Import(AppConfig.class)
public class BootDaoProj6CallbackInterfaceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		EmployeeDTO dto=null;
		List<EmployeeDTO> listDTO=null;
		ctx=SpringApplication.run(BootDaoProj6CallbackInterfaceApplication.class, args);
		 //get Service class obj
		  service=ctx.getBean("empService",EmployeeMgmtService.class);
		//invoke methods
		try {
		 
			System.out.println("7499 emp details are::"+service.findEmployeeByNo(7499));
		    listDTO=service.findEmployeesByDesgs("CLERK","MANAGER","SALESMAN");
			listDTO.forEach(dto1->{
				System.out.println(dto1);
			});
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
