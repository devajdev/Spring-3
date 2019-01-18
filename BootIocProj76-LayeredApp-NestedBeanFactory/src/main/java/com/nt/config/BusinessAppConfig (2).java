package com.nt.config;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

//@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@SpringBootApplication
@ComponentScan(basePackages= {"com.nt.service","com.nt.dao"})
public class BusinessAppConfig {
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource createDataSource() {
		BasicDataSource ds=null;
		ds=new BasicDataSource();
		/*ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("system");
		ds.setPassword("manager");*/
		
		ds.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));
		ds.setUrl(env.getRequiredProperty("spring.datasource.url"));
		ds.setUsername(env.getRequiredProperty("spring.datasource.username"));
		ds.setPassword(env.getRequiredProperty("spring.datasource.password"));
		return ds;
		
	}
	
	}
