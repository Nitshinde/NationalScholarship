package com.example.nationalscholarship.nationalscholarship.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@PropertySource(value = {"classpath:application.properties"})
@Configuration
public class DBConfig {
	
	
	@Value("${spring.datasource.driverClassName}")
	private String driverClass;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.jpa.properties.hibernate.dialect}")
	private String dialect;
	
	@Bean
	public DataSource getDatasource()
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource(url, username, password);
		datasource.setDriverClassName(driverClass);
		return datasource;
	
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.hbm2ddl.auto", "update");
		// properties.put("hibernate.show_sql", "true");
		// properties.put("hibernate.format_sql", "true");
		properties.put("connection.autocommit", "true");
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory()
	{
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(getDatasource());
		factory.setHibernateProperties(hibernateProperties());
		factory.setPackagesToScan(new String[] {"com.example.nationalscholarship.nationalscholarship.model"});
		return factory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory factory)
	{
		HibernateTransactionManager transactionManger = new HibernateTransactionManager();
		transactionManger.setSessionFactory(factory);
		return transactionManger;
		
	}
}
