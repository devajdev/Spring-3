package com.nt.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.EmployeeMgmtService;

public class CURDOperationsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		List<Map<String,Object>>  list=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		//invoke method
		try {
			System.out.println("Employees Count::"+service.findEmployeesCount());
			System.out.println("Employee Salary::"+service.findEmployeeSalaryByNo(7499));
			System.out.println("7499 Employee Details::"+service.findEmplyeeDetailsByNo(7499));
			System.out.println("List of Employees::"+service.findEmployeesByDesgs("CLERK","MANAGER","SALESMAN"));
			System.out.println(service.hikeSalaryByEmpNo(7499,15));
			//System.out.println(service.registerEmployee(8991,"rajesh", "CLERK",8000));
			System.out.println(service.fireEmployee(8991));
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
