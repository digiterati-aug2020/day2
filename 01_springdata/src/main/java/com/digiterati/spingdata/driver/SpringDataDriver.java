package com.digiterati.spingdata.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.digiterati.jpa.entity.TestJpaData;
import com.digiterati.spingdata.repository.TestDataJpaRepository;


@SpringBootApplication
@EntityScan("com.digiterati.jpa.entity")
@EnableJpaRepositories(basePackages = "com.digiterati.spingdata.repository")
public class SpringDataDriver {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(SpringDataDriver.class, args);
		
		TestDataJpaRepository repo = ctx.getBean(TestDataJpaRepository.class);
		
		TestJpaData data = new TestJpaData();
		data.setRemarks("spring data");
		repo.save(data);
		
		System.out.println(repo.findAll());
		System.out.println(repo.findById(1));
		
		((ConfigurableApplicationContext)ctx).close();
		
		
	}

}
