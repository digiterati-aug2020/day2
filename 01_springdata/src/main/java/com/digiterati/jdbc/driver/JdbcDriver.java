package com.digiterati.jdbc.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.digiterati.jdbc.repository.JdbcDataRepository;

@SpringBootApplication
@ComponentScan("com.digiterati.jdbc.repository")
public class JdbcDriver {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(JdbcDriver.class, args);
		
		JdbcDataRepository repo = ctx.getBean(JdbcDataRepository.class);
		
		repo.insert("test1");
		
		System.out.println(repo.getTestDataList());
		
		((ConfigurableApplicationContext)ctx).close();
		
		
	}

}
