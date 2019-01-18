package com.nt.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.dto.UserDTO;
import com.nt.service.LoginService;

public class SimpleJdbcCallTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		LoginService service=null;
		Scanner sc=null;
		UserDTO dto=null;
		String user=null,pass=null;
		//create IOC container 
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Service
		service=ctx.getBean("loginService",LoginService.class);
		//read input
		sc=new Scanner(System.in);
		System.out.println("Enter username::");
		user=sc.next(); //gives raja
		System.out.println("Enter password::");
		pass=sc.next(); //gives rani
		//prpeare DTO
		dto=new UserDTO();
		dto.setUsername(user); dto.setPassword(pass);
		//invoke method
		try {
			System.out.println(service.authenticate(dto));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
