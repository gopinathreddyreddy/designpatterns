package com.design.patterns.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SampleSingleton {

	private static volatile SampleSingleton instance = null;
	private static volatile Connection conn = null;
	
	private SampleSingleton() {
		
		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(conn != null) {
			throw new RuntimeException("Use getConnection() method to create");
		}
		
		if(instance != null) {
			throw new RuntimeException("Use getInstance() method to create");
		}
	}
	
	public static SampleSingleton getInstance() {
		if(instance == null) {
			synchronized(SampleSingleton.class) {
				if(instance == null) {
					instance = new SampleSingleton();
				}
			}
		}
		
		return instance;
	}
	
	public Connection getConnection() {
		if(conn == null) {
			synchronized (SampleSingleton.class) {
				if(conn == null) {
					try {
						String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
						
						conn = DriverManager.getConnection(dbUrl);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return conn;
	}
}
