package com.market.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	private static Connection conn = null;
	private static String address = "jdbc:mysql://localhost:3306/qxtest?useSSL=false&serverTimezone=UTC";
	private static String uname = "root";
	private static String upwd = "123456";
	
	public static Connection getConnection() {
		try {
			if(conn==null) {
				// 加载jdbc驱动
				Class.forName("com.mysql.cj.jdbc.Driver");
				// 获取连接对象
				conn = DriverManager.getConnection(address, uname, upwd);
				System.out.println("-------------数据库连接成功！");
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
