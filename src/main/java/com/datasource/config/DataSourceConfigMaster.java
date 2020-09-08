package com.datasource.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfigMaster {

    @Value("${spring.datasource.master.url}")
    private String url;
    @Value("${spring.datasource.master.username}")
    private String username;
    @Value("${spring.datasource.master.password}")
    private String password;
    @Value("${spring.datasource.master.driver-class-name}")
    private String driverClassName;

    @Bean(name = "masterDataSource")
    @Qualifier("masterDataSource")
    public DataSource masterDataSource() {
        // DataSource dataSource= DataSourceBuilder.create().build();
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(url);
        dataSource.setDriverClassName(driverClassName);

        return dataSource;
    }

    @Bean(name = "masterJdbcTemplate")
    public JdbcTemplate masterJdbcTemplate(@Qualifier("masterDataSource") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }


}
