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
				// ����jdbc����
				Class.forName("com.mysql.cj.jdbc.Driver");
				// ��ȡ���Ӷ���
				conn = DriverManager.getConnection(address, uname, upwd);
				System.out.println("-------------���ݿ����ӳɹ���");
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
