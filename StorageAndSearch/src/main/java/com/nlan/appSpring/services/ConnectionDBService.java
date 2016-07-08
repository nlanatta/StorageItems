package com.nlan.appSpring.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.nlan.appSpring.config.DataBaseConfig;

@Component
public class ConnectionDBService {	
	
	@Resource
    private DataBaseConfig dbConfig;
	
	public Connection getConnectionStorageDB() throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUsername(), dbConfig.getPassword());
		return connection;
	}
}
