package com.market.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Calendar;

import com.market.pojo.Order;
import com.market.util.GetConnection;

// 订单数据库操作
public class OrderDao {
	// 订单数据库编辑
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
			System.out.println("订单从数据库编辑异常:"+e);
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
	
	// 订单从数据库获取
	public ArrayList<Order> getDataBySql(String sql) {
		Connection conn=null;
		Statement stmt=null;
		ArrayList<Order> ordersList=new ArrayList<Order>();
		try {
			conn=GetConnection.getConnection();
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql); 
			while(rs.next()) {
				Order order=new Order(rs.getInt("id"),rs.getInt("count"),rs.getDouble("amount"),rs.getTimestamp("time"));
//				Calendar cal;
				ordersList.add(order);
			}
			
		}catch(Exception e) {
			System.out.println("订单从数据库获取异常:"+e);
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
		return ordersList;
	}
}
