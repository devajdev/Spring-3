package com.nt.test;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;


import com.nt.config.AppConfig;
import com.nt.dto.UserDTO;
import com.nt.service.LoginService;

@SpringBootApplication
@Import(value=AppConfig.class)
public class SimpleJdbcCallTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		LoginService service=null;
		Scanner sc=null;
		UserDTO dto=null;
		String user=null,pass=null;
		//get IOC container 
		ctx=SpringApplication.run(SimpleJdbcCallTest.class, args);
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
