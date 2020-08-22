package com.digiterati.mongo.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EntityScan("com.digiterati.mongo.entity")
@ComponentScan({"com.digiterati.mongo.controller"})
@EnableMongoRepositories(basePackages="com.digiterati.mongo.repository")
public class MongoDriver extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(MongoDriver.class,args);
	}
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(MongoDriver.class);
	    }

}
