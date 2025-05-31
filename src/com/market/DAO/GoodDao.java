package com.market.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.market.pojo.Good;
import com.market.util.GetConnection;

// 商品数据库操作
public class GoodDao {

	// 商品更新数据
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
			System.out.println("商品从数据库异常:"+e);
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
	
	// 商品获取数据
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
			System.out.println("商品从数据库获取异常:"+e);
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
