package com.digiterati.spring.docs.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.digiterati.spring.docs.controller","com.digiterati.spring.docs.repository"})
@Import(SwaggerConfiguration.class)
public class SubjectConfiguration {

	
}
