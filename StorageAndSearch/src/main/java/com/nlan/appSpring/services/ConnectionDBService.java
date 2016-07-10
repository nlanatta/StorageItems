package com.nlan.appSpring.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.nlan.appSpring.config.DataBaseConfig;
import com.nlan.appSpring.model.Item;

@Component
@EnableTransactionManagement
public class ConnectionDBService {

	@Resource
	private DataBaseConfig dbConfig;

	public Connection getConnectionStorageDB() throws SQLException {
		try {
			Class.forName(dbConfig.getDriver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUsername(),
				dbConfig.getPassword());
		return connection;
	}

	@Bean(name = "dataSource")
	private DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(dbConfig.getDriver());
		ds.setUrl(dbConfig.getUrl());
		ds.setUsername(dbConfig.getUsername());
		ds.setPassword(dbConfig.getPassword());
		return ds;
	}

	@Bean(name = "sessionFactory")
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
		builder.scanPackages("com.nlan.appSpring.config");
		builder.addProperties(getHibernateProperties());
		builder.addAnnotatedClass(Item.class);
		return builder.buildSessionFactory();
	}

	@Autowired
	@Bean
	public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

	@Autowired
	@Bean
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		return hibernateTemplate;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dbConfig.getDialect());
		properties.put("hibernate.show_sql", dbConfig.getShowSql());
		properties.put("hibernate.hbm2ddl.auto", dbConfig.getHbm2dllAuto());
		properties.put("hibernate.pool_size", dbConfig.getPoolSize());
		//properties.put("hibernate.current_session_context_class", dbConfig.getCurrentSessionContextClass());
		return properties;
	}

}
