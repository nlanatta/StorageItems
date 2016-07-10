package com.nlan.appSpring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.nlan.appSpring")
@PropertySource("classpath:database.properties")
public class DataBaseConfig {
	@Value("${jdbc.driverClassName}")
	private String driver;
	
	public String getDriver() {
		return driver;
	}

	@Value("${jdbc.url}")
	private String url;

	public String getUrl() {
		return url;
	}

	@Value("${jdbc.username}")
	private String username;

	public String getUsername() {
		return username;
	}

	@Value("${jdbc.password}")
	private String password;
	
	@Value("${hibernate.show_sql}")
	private String showSql;
	
	@Value("${hibernate.hbm2ddl.auto}")	
	private String hbm2dllAuto;
	
	@Value("${hibernate.generate_statistics}")
	private String generateStatistics;
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Value("${hibernate.current_session_context_class}")
	private String currentSessionContextClass;	

	@Value("${hibernate.pool_size}")
	private String poolSize;
	
	public String getCurrentSessionContextClass() {
		return currentSessionContextClass;
	}
	public String getPoolSize() {
		return poolSize;
	}
	
	public String getPassword() {
		return password;
	}
	public String getDialect() {
		return dialect;
	}

	public String getShowSql() {
		return showSql;
	}

	public String getHbm2dllAuto() {
		return hbm2dllAuto;
	}

	public String getGenerateStatistics() {
		return generateStatistics;
	}

}
