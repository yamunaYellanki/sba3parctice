package com.demo.spring;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.demo.spring")
@EnableTransactionManagement
public class AppConfig 
{

	@Bean
	public BasicDataSource dataSource()
	{
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb");
		ds.setUsername("root");
		ds.setPassword("password");
		ds.setInitialSize(4);
		ds.setMaxActive(10);
		return ds;
	
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean  emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("com.demo.spring");
		
		HibernateJpaVendorAdapter hva = new HibernateJpaVendorAdapter();
		hva.setDatabase(Database.MYSQL);
		hva.setShowSql(true);
		
		emf.setJpaVendorAdapter(hva);
		return emf;
	}
	@Bean
	public JpaTransactionManager transactionManager()
	{
		JpaTransactionManager txm = new JpaTransactionManager();
		txm.setEntityManagerFactory(entityManagerFactory().getObject());
		return txm;
	}
	
}
