package com.qixin.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GetConnection {

	public static void main(String[] args){
		Connection conn = null; // 数据库连接对象
		Statement stmt = null; // Statement对象，用于执行sql语句
		try {
			// 加载jdbc驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 获取连接对象
			String address = "jdbc:mysql://localhost:3306/qxtest?useSSL=false&serverTimezone=UTC";
			String uname = "root";
			String upwd = "123456";
			conn = DriverManager.getConnection(address, uname, upwd);
			System.out.println("-------------数据库连接成功！");
			
			stmt = conn.createStatement();
//			String sqlAdd = "INSERT into tests VALUES(1003,'wangwu',25);";
//			String sqlUpdate = "UPDATE tests SET name='王五' WHERE id=1003;";
			String sqlDelete = "DELETE FROM tests WHERE id=1003;";
			stmt.execute(sqlDelete);// 执行sql语句
			System.out.println("数据已更新！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("-------------数据库连接异常："+e);
		} finally {
			// 关闭Statement
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 关闭数据库
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
