package com.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfigSlave {

    @Value("${spring.datasource.slave.url}")
    private String url;
    @Value("${spring.datasource.slave.username}")
    private String username;
    @Value("${spring.datasource.slave.password}")
    private String password;
    @Value("${spring.datasource.slave.driver-class-name}")
    private String driverClassName;

    @Bean(name = "slaveDataSource")
    @Qualifier("slaveDataSource")
    // @ConfigurationProperties(prefix="spring.datasource.slave")
    public DataSource slaveDataSource() {
        // DataSource dataSource= DataSourceBuilder.create().build();
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);

        return dataSource;
    }

    @Bean(name = "slaveJdbcTemplate")
    public JdbcTemplate slaveJdbcTemplate(@Qualifier("slaveDataSource") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }


}
