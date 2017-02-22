package com.nlan.appSpring.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import com.mysql.cj.jdbc.MysqlDataSource;


public class ServerMysql {

	public static void main(String[] args) throws IOException {
		System.out.println("server is running");
		runAndCreateMYSQLDB();
	}

	public static void runAndCreateMYSQLDB() throws IOException {
		Properties database = database();
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("db_items_storage");
		dataSource.setUrl(database.getProperty("jdbc.url")+"?createDatabaseIfNotExist=true");
		dataSource.setUser(database.getProperty("jdbc.username"));
		dataSource.setPassword(database.getProperty("jdbc.password"));

//		ResourceDatabasePopulator rdp = new ResourceDatabasePopulator();    
//		rdp.addScript(new ClassPathResource(
//		                        "querys/create_db_storage_table.sql"));
		
		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName(database.getProperty("jdbc.driverClassName")).newInstance();
		} catch (Exception e) {
			System.err.println("ERROR: failed to load JDBC driver.");
			e.printStackTrace();
			return;
		}

		try {
			connection = dataSource.getConnection();
			//rdp.populate(connection);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
		}
		if (connection == null) {
			System.out.println(" connection null");
			return;
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void createTable(String table, String query, Statement statement) throws SQLException
	{
		statement.executeUpdate("DROP TABLE IF EXISTS "+table+ "CASCADE");
		statement.executeUpdate(query);		
	}

	public static void closeServer() {
	}

	private static Properties database() {
		Properties prop = new Properties();
		InputStream stream = null;

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try {
			stream = loader.getResourceAsStream("database.properties");
		} finally {
			if (stream != null) {
				try {
					prop.load(stream);
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return prop;
	}
}
