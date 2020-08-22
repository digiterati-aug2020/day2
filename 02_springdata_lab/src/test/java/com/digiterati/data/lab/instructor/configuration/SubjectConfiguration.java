package com.digiterati.data.lab.instructor.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EntityScan("com.digiterati.data.lab.instructor.entity")
@EnableJpaRepositories(basePackages = "com.digiterati.data.lab.instructor.repository")
@ComponentScan({"com.digiterati.data.lab.instructor.controller"})
public class SubjectConfiguration {

}
