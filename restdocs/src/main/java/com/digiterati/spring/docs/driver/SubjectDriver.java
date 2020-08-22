package com.digiterati.spring.docs.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.digiterati.spring.docs.configuration.SubjectConfiguration;

@SpringBootApplication(scanBasePackageClasses = SubjectConfiguration.class)
public class SubjectDriver extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(SubjectDriver.class,args);
	}
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(SubjectDriver.class);
	    }

}
