package com.digiterati.jdbc.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.digiterati.jdbc.repository")
@EnableAutoConfiguration
public class JdbcTestConfiguration {

}
