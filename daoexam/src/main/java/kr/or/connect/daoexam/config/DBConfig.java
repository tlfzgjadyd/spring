package kr.or.connect.daoexam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	private String driverClassName="com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/ROLE?useUnicode=true&characterEncoding=utf8";
    												//이떄 ?이전에 나오는건 DB명이어야했다
    private String username = "connectuser";
    private String password = "1234";
    
    @Bean
    public DataSource dataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;

    }
}
