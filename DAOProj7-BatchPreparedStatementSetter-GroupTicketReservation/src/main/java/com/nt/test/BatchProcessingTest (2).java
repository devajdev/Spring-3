package com.nt.test;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.TicketDetailsDTO;
import com.nt.service.TravelMgmtService;

public class BatchProcessingTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		TravelMgmtService service=null;
		Scanner sc=null;
		String source=null,dest=null,psgName=null;
		int size=0;
		int age=0;
		TicketDetailsDTO dto=null;
		List<TicketDetailsDTO> listDTO=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("TAService",TravelMgmtService.class);
		//read inputs
		sc=new Scanner(System.in);
		System.out.println("Enter group size");
		size=sc.nextInt();
		System.out.println("Enter Source place:");
		source=sc.next();
		System.out.println("Enter Dest place:");
		dest=sc.next();
		listDTO=new ArrayList();
		
		for(int i=1;i<=size;++i) {
			dto=new TicketDetailsDTO();
			System.out.println("Enter"+i+" passegener name:");
			psgName=sc.next();
			System.out.println("enter"+i+"passegener age::");
			age=sc.nextInt();
			//prepare DTO
			dto.setPsgName(psgName);
			dto.setAge(age);
			dto.setSource(source);
			dto.setDest(dest);
			//add to ListDTO
			listDTO.add(dto);
		}//for
		
		//invoke method
		try {
			System.out.println(service.groupReservation(listDTO));
		}
       catch(Exception e) {
    	   e.printStackTrace();
       }
     //close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
