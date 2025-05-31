package com.qixin.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

import utils.GetConnection;

public class DemoOne {

	public static void main(String[] args) {
		Connection conn = null; // ���ݿ����Ӷ���
		Statement stmt = null; // Statement��������ִ��sql���
		try {
			
			conn = GetConnection.getConnection();
			System.out.println("-------------���ݿ����ӳɹ���");
			
			stmt = conn.createStatement();
//			String sqlAdd = "INSERT into tests VALUES(1003,'wangwu',25);";
//			String sqlUpdate = "UPDATE tests SET name='����' WHERE id=1003;";
//			String sqlDelete = "DELETE FROM tests WHERE id=1003;";
//			stmt.execute(sqlDelete);// ִ��sql���
			//��ѯһ������
//			String sqlSelect="select * from tests where id=1001;";
//			ResultSet rs=stmt.executeQuery(sqlSelect);
//			if(rs.next()) {
//				Test t=new Test(rs.getInt("id"),rs.getString("name"),rs.getInt("age"));
//				System.out.println(t.getId());
//				System.out.println(t.getName());
//				System.out.println(t.getAge());
//			}
			//��ѯ��������
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
