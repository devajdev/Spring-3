package com.nt.test;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.BusinessAppConfig;
import com.nt.config.PresentationAppConfig;
import com.nt.controller.MainController;
import com.nt.dto.EmployeeDTO;

//@SpringBootApplication
public class BootIocProj76LayeredAppNestedBeanFactoryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext pCtx=null,cCtx=null;
		MainController controller=null;
		List<EmployeeDTO> listDTO=null;
		//parent container
		pCtx=SpringApplication.run(BusinessAppConfig.class, args);
		//child container
		cCtx=SpringApplication.run(PresentationAppConfig.class, args);
        cCtx.setParent(pCtx);
		//get Controller obj
		controller=cCtx.getBean("controller",MainController.class);
		try {
		//invoke the method
		listDTO=controller.searchEmpsByDesgs("CLERK", "MANAGER","SALESMAN");
		 
		 listDTO.forEach(dto->{
			 System.out.println(dto.getSno()+" "+dto.getEmpName()+" "+dto.getEmpDesg()+" "+dto.getEmpSalary()+" "+dto.getDeptNo()+" "+dto.getMgrNo());
		 });
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close containers
		pCtx.close();
		cCtx.close();
	}
}
