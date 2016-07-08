package com.nlan.appSpring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.nlan.appSpring")
@PropertySource("classpath:database.properties")
public class DataBaseConfig {
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

	public String getPassword() {
		return password;
	}
}
