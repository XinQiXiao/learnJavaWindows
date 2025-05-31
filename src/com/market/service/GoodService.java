package com.market.service;

import java.util.ArrayList;
import java.util.Scanner;
import com.market.DAO.GoodDao;
import com.market.pojo.Good;

// 编写商品相关业务方法
public class GoodService {
	
	GoodDao goodDAO=new GoodDao();
	
	// 展示所有商品
	public void showAllGoods() {
		String sql="select * from goods;";
		ArrayList<Good> goodsList=goodDAO.getDataBySql(sql);
		System.out.println("---------------------商品列表---------------------");
		for(Good good:goodsList) {
			System.out.println(good.getId()+"   "+good.getName()+"   "+good.getPrice()+"   "+good.getStock());
		}
		System.out.println("---------------------------");
	} 
	
	// 商品上架
	public void addGoods() {
		
		Scanner s=new Scanner(System.in);
		System.out.println("请输入增加的商品名称：");
		String name=s.next();
		System.out.println("请输入增加的商品价格：");
		double price=s.nextDouble();
		String sql="insert into goods(name,price) values('"+name+"',"+price+");";
		boolean result=goodDAO.setDataBySql(sql);
		if (result) {
			System.out.println("-----添加成功");
		}else {
			System.out.println("------添加失败");
		}
	}
	
	// 商品下架
	public void delGood() {
	
		Scanner s=new Scanner(System.in);
		System.out.println("请输入要下架的商品id:");
		int id=s.nextInt();
		
		String sql="delete from goods where id="+id+";";
		boolean result=goodDAO.setDataBySql(sql);
		if (result) {
			System.out.println("-----删除成功");
		}else {
			System.out.println("------删除失败");
		}
	}
	
	// 商品价格修改
	public void setPrice() {
		
		Scanner s=new Scanner(System.in);
		System.out.println("请输入要修改价格的商品id:");
		int id=s.nextInt();
		System.out.println("请输入修改后的价格");
		double newPrice=s.nextDouble();
		String sql="update goods set price="+newPrice+" where id="+id+";";
		boolean result=goodDAO.setDataBySql(sql);
		if (result) {
			System.out.println("-----修改成功");
		}else {
			System.out.println("------修改失败");
		}
	}
	
	// 修改数量
	public void setStock() {
		
		Scanner s=new Scanner(System.in);
		System.out.println("请输入要修改库存量商品的id:");
		int id=s.nextInt();
		System.out.println("请输入修改后的库存量");
		int stock=s.nextInt();
		if(stock>=0) {
			String sql="update goods set stock="+stock+" where id="+id+";";
			boolean result=goodDAO.setDataBySql(sql);
			if (result) {
				System.out.println("-----修改成功");
			}else {
				System.out.println("------修改失败");
			}
		}else {
			System.out.println("-----库存量必须大于0");
		}
		
	}
	
}
