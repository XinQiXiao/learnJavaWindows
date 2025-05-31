package com.qixin.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GetConnection {

	public static void main(String[] args){
		Connection conn = null; // ���ݿ����Ӷ���
		Statement stmt = null; // Statement��������ִ��sql���
		try {
			// ����jdbc����
			Class.forName("com.mysql.cj.jdbc.Driver");
			// ��ȡ���Ӷ���
			String address = "jdbc:mysql://localhost:3306/qxtest?useSSL=false&serverTimezone=UTC";
			String uname = "root";
			String upwd = "123456";
			conn = DriverManager.getConnection(address, uname, upwd);
			System.out.println("-------------���ݿ����ӳɹ���");
			
			stmt = conn.createStatement();
//			String sqlAdd = "INSERT into tests VALUES(1003,'wangwu',25);";
//			String sqlUpdate = "UPDATE tests SET name='����' WHERE id=1003;";
			String sqlDelete = "DELETE FROM tests WHERE id=1003;";
			stmt.execute(sqlDelete);// ִ��sql���
			System.out.println("�����Ѹ��£�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("-------------���ݿ������쳣��"+e);
		} finally {
			// �ر�Statement
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// �ر����ݿ�
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
