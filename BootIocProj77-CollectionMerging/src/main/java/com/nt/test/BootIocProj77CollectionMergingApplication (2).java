package com.nt.test;

import javax.print.attribute.standard.MediaSize.Engineering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.beans.EnggCourse;
import com.nt.config.AppConfig;

@SpringBootApplication
@Import(AppConfig.class)
public class BootIocProj77CollectionMergingApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EnggCourse course=null;
		ctx=SpringApplication.run(BootIocProj77CollectionMergingApplication.class, args);
		//get Bean
		course=ctx.getBean("eceEngg1stSem",EnggCourse.class);
		System.out.println(course);
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}
}
