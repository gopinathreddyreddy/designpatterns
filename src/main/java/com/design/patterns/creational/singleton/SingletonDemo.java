package com.design.patterns.singleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonDemo {

	public static void main(String[] args) {
		SampleSingleton instance = SampleSingleton.getInstance();

		long timeBefore = 0;
		long timeAfter = 0;
		
		System.out.println(instance);

		timeBefore = System.currentTimeMillis();
		Connection conn = instance.getConnection();
		timeAfter = System.currentTimeMillis();

		System.out.println(timeAfter - timeBefore);

		Statement sta;
		try {
			sta = conn.createStatement();
			int count = sta
					.executeUpdate("CREATE TABLE MyAddress (ID INT, Street VARCHAR(20),"
							+ " City VARCHAR(20))");
			System.out.println("Table created.");
			sta.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		timeBefore = System.currentTimeMillis();
		conn = instance.getConnection();
		timeAfter = System.currentTimeMillis();

		System.out.println(timeAfter - timeBefore);


		System.out.println(conn);

		try {
			sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("Select * from MyAddress");
			
			System.out.println(rs);
			rs.close();
			sta.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
