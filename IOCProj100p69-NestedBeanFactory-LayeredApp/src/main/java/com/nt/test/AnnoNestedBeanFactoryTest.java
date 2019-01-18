package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.BusinessAppConfig;
import com.nt.config.PresentationAppConfig;
import com.nt.controller.MainController;
import com.nt.dto.EmployeeDTO;

public class AnnoNestedBeanFactoryTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext pCtx=null,cCtx=null;
		MainController controller=null;
		List<EmployeeDTO> listDTO=null;
		//create Parent IOC container
		pCtx=new AnnotationConfigApplicationContext(BusinessAppConfig.class);
		//create Child IOC container
		/*cCtx=new AnnotationConfigApplicationContext(PresentationAppConfig.class);
		cCtx.setParent(pCtx);*/
		
		cCtx=new AnnotationConfigApplicationContext();
		cCtx.setParent(pCtx);
		cCtx.register(PresentationAppConfig.class);
		cCtx.refresh();
		
		//Get Bean
		controller=cCtx.getBean("controller",MainController.class);
		//invoke method
		try{
			listDTO=controller.searchEmpsByDesgs("CLERK","SALESMAN","MANAGER");
			//display details
			listDTO.forEach(dto->{
				System.out.println(dto);
			});
		}//try
		catch(Exception se){
			se.printStackTrace();
		}
		

	}//main
}//class
