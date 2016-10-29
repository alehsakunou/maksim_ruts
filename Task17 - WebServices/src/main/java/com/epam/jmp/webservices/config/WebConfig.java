package com.epam.jmp.webservices.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Maksim Ruts on 10/29/2016.
 * Settings for web application
 */
@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@ComponentScan("com.epam.jmp.webservices.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
}
