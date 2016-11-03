package com.epam.jmp.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by Maksim Ruts on 11/3/2016.
 * Data base config
 */
@Configuration
public class DataBaseConfig {
    /**
     * returns JDBC template
     * @return JDBC template
     */
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    /**
     * returns data source
     * @return data source
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/jmp");
        dataSource.setUsername("jmp");
        dataSource.setPassword("jmp");
        return dataSource;
    }
}
