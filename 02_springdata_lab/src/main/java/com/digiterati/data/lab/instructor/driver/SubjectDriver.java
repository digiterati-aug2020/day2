package com.digiterati.data.lab.instructor.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.digiterati.data.lab.instructor.entity")
@EnableJpaRepositories(basePackages = "com.digiterati.data.lab.instructor.repository")
@ComponentScan({"com.digiterati.data.lab.instructor.controller"})
public class SubjectDriver extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(SubjectDriver.class,args);
	}
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(SubjectDriver.class);
	    }

}
