package com.nt.test;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

@SpringBootApplication
@Import(AppConfig.class)
public class DaoProj10NamedParameterJdbcTemplateApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		EmployeeMgmtService service = null;
		List<EmployeeDTO> listDTO = null;
		EmployeeDTO myDTO = null;
		// get IOC container
		ctx = SpringApplication.run(DaoProj10NamedParameterJdbcTemplateApplication.class, args);
		// get Bean
		service = ctx.getBean("empService", EmployeeMgmtService.class);
		try {
			listDTO = service.fetchEmployeesBySalaryRange(1000, 2000);
			listDTO.forEach(dto -> {
				System.out.println(dto);
			});
			System.out.println("................");
			myDTO = new EmployeeDTO();
			myDTO.setEno(9006);
			myDTO.setEname("ramesh");
			myDTO.setSalary(7000);
			myDTO.setDesg("CLERK");
			System.out.println(service.registerEmp(myDTO));

		} // try
		catch (Exception e) {
			e.printStackTrace();
		}

		// close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
