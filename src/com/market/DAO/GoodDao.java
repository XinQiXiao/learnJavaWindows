package com.market.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.market.pojo.Good;
import com.market.util.GetConnection;

// ��Ʒ���ݿ����
public class GoodDao {

	// ��Ʒ��������
	public boolean setDataBySql(String sql) {
		Connection conn=null;
		Statement stmt=null;
		boolean msg=false;
		try {
			conn=GetConnection.getConnection();
			stmt=conn.createStatement();
			int i=stmt.executeUpdate(sql); 
			if(i>0) {
				msg=true;
			}
		}catch(Exception e) {
			System.out.println("��Ʒ�����ݿ��쳣:"+e);
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return msg;
	}
	
	// ��Ʒ��ȡ����
	public ArrayList<Good> getDataBySql(String sql) {
		Connection conn=null;
		Statement stmt=null;
		ArrayList<Good> goodsList=new ArrayList<Good>();
		try {
			conn=GetConnection.getConnection();
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql); 
			while(rs.next()) {
				Good good=new Good(rs.getInt("id"),rs.getString("name"),rs.getDouble("price"),rs.getInt("stock"));
				goodsList.add(good);
			}
			
		}catch(Exception e) {
			System.out.println("��Ʒ�����ݿ��ȡ�쳣:"+e);
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return goodsList;
	}
}
