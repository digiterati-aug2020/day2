package com.digiterati.jpa.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.digiterati.jpa.repository.JpaDataRepository;

@SpringBootApplication
@ComponentScan("com.digiterati.jpa.repository")
@EntityScan("com.digiterati.jpa.entity")
public class JpaDataDriver {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(JpaDataDriver.class, args);
		
		JpaDataRepository repo = ctx.getBean(JpaDataRepository.class);
		
		repo.insert("jpa test1");
		
		System.out.println(repo.getTestDataList());
		
		((ConfigurableApplicationContext)ctx).close();
		
		
	}

	
}
