package com.nlan.appSpring.services;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.nlan.appSpring.config.DataBaseConfig;

@Component
@EnableJpaRepositories("com.nlan.appSpring.repository")
@EnableTransactionManagement
public class ConnectionDBService {

	@Resource
	private DataBaseConfig dbConfig;

	@Bean(name = "dataSource")
	private DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(dbConfig.getDriver());
		ds.setUrl(dbConfig.getUrl());
		ds.setUsername(dbConfig.getUsername());
		ds.setPassword(dbConfig.getPassword());
		return ds;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.nlan.appSpring");
		factory.setDataSource(dataSource());
		factory.setJpaProperties(getHibernateProperties());
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dbConfig.getDialect());
		properties.put("hibernate.show_sql", dbConfig.getShowSql());
		properties.put("hibernate.format_sql", dbConfig.getFormatSql());
		properties.put("hibernate.hbm2ddl.auto", dbConfig.getHbm2dllAuto());
		properties.put("hibernate.pool_size", dbConfig.getPoolSize());
		properties.put("hibernate.generate_statistics", dbConfig.getGenerateStatistics());
		return properties;
	}

}
