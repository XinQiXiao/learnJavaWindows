package com.market.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	private static Connection conn=null;
	private static String address="jdbc:mysql://localhost:3306/qxtest?"
			+ "useSSL=false&serverTimezone=UTC";
	private static String uname="root";
	private static String upwd="123456";
	
	public static Connection getConnection() {
		try {
			conn=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(address,uname,upwd);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
