package com.qixin.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

import utils.GetConnection;

public class DemoOne {

	public static void main(String[] args) {
		Connection conn = null; // 数据库连接对象
		Statement stmt = null; // Statement对象，用于执行sql语句
		try {
			
			conn = GetConnection.getConnection();
			System.out.println("-------------数据库连接成功！");
			
			stmt = conn.createStatement();
//			String sqlAdd = "INSERT into tests VALUES(1003,'wangwu',25);";
//			String sqlUpdate = "UPDATE tests SET name='王五' WHERE id=1003;";
//			String sqlDelete = "DELETE FROM tests WHERE id=1003;";
//			stmt.execute(sqlDelete);// 执行sql语句
			//查询一条数据
//			String sqlSelect="select * from tests where id=1001;";
//			ResultSet rs=stmt.executeQuery(sqlSelect);
//			if(rs.next()) {
//				Test t=new Test(rs.getInt("id"),rs.getString("name"),rs.getInt("age"));
//				System.out.println(t.getId());
//				System.out.println(t.getName());
//				System.out.println(t.getAge());
//			}
			//查询多条数据
			String sqlSelect="select * from tests;";
			ResultSet rs=stmt.executeQuery(sqlSelect);
			ArrayList<Test> testList=new ArrayList<Test>();
			while(rs.next()) {
				Test t=new Test(rs.getInt("id"),rs.getString("name"),rs.getInt("age"));
				testList.add(t);
//				System.out.println(rs.getInt("id"));
//				System.out.println(rs.getString("name"));
//				System.out.println(rs.getInt("age"));
			}
			
			for(Test t:testList) {
				System.out.println(t.getId());
				System.out.println(t.getName());
				System.out.println(t.getAge());
			}
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
