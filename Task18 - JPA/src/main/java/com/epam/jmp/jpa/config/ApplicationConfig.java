package com.epam.jmp.jpa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Maksim Ruts on 11/3/2016.
 * General application config
 */
@Configuration
@ComponentScan("com.epam.jmp.jpa")
@Import({DataBaseConfig.class, HibernateConfig.class})
public class ApplicationConfig {
}
