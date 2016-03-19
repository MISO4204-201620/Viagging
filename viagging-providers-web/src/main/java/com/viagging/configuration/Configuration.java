package com.viagging.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 
@org.springframework.context.annotation.Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.viagging.rest.controllers")
public class Configuration {
     
 
}