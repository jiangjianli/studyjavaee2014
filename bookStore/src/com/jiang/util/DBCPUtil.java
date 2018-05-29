package com.jiang.util;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtil {

	private static DataSource dataSource;
	
	
	static {
		
		try {
			InputStream inputStream = DBCPUtil.class.getClassLoader().getResourceAsStream("");
			
			Properties properties = new Properties();
			
			properties.load(inputStream);
			
			dataSource = BasicDataSourceFactory.createDataSource(properties);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new ExceptionInInitializerError(e);
		}
		
	}
	
	
	public static DataSource getdatasource() {
		
		return dataSource;
	}
	
	
	public static Connection getConnection () {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
		
	}
	
}
