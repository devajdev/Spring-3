package com.nt.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.EnggAspraintDTO;
import com.nt.service.OnlineCousellingMgmtService;

public class SimpleJdbcInsertTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		OnlineCousellingMgmtService service=null;
		EnggAspraintDTO dto=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class obj
		service=ctx.getBean("oCService",OnlineCousellingMgmtService.class);
		//invoke method
		try {
			dto=new EnggAspraintDTO();
			dto.setHtNo(9002);
			dto.setRank(4);
			dto.setDob(new Date(90,10,25));
			dto.setPrefferedStreams("EC,CSE,EEE");
			dto.setPrefferedColleges("CBIET,VJIT,JBIT");
			System.out.println(service.register(dto));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
