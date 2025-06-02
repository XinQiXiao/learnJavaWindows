package com.market.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.market.DAO.GoodDao;
import com.market.DAO.OrderDao;
import com.market.pojo.Good;
import com.market.pojo.Order;
import com.market.util.DatetimeUtil;

// 编写订单业务
public class OrderService {
	OrderDao orderDAO=new OrderDao();
	GoodDao goodDAO=new GoodDao();
	Scanner s=new Scanner(System.in);
	GoodService goodService=new GoodService();
	
	// 获取所有订单
	public void getAllOrders() {
		String sql="select * from orders;";
		ArrayList<Order> ordersList=orderDAO.getDataBySql(sql);
		System.out.println("---------------------所有订单列表---------------------");
		for(Order order:ordersList) {
			System.out.println(order.getId()+"    "+order.getCount()+"    "+
			order.getAmount()+"    "+order.getTime());
		}
		System.out.println("---------------------------------------------");
	}
	
	// 添加订单
	public boolean addOrder(Order order) {
		String sql="insert into orders(count,amount,time) values("+order.getCount()+","+order.getAmount()+",'"+order.getTime()+"');";
		//System.out.println("addOrderSql:"+sql);
		boolean result=orderDAO.setDataBySql(sql);
		if(result) {
			System.out.println("-----添加订单成功");
		}else {
			System.out.println("-----添加订单失败");
		}
		return result;
	}
	
	// 删除订单
	public void delOrder() {
		System.out.println("---------------------删除订单---------------------");
		Scanner s=new Scanner(System.in);
		System.out.println("请输入要删除订单id:");
		int id=s.nextInt();
		
		String sql="delete from orders where id="+id+";";
		boolean result=goodDAO.setDataBySql(sql);
		if (result) {
			System.out.println("-----删除订单成功");
		}else {
			System.out.println("------删除订单失败");
		}
	}
	
	// 收银台
	public void cashier() {
		int totalCount=0;// 用户购买总件数
		double totalAmount=0;// 用户购买总金额
		System.out.println("---------------------收银台---------------------");
		while(true) {
			System.out.println("请输入商品id:");
			int id=s.nextInt();
			System.out.println("请输入勾选数量：");
			int count=s.nextInt();
			String sql="select * from goods where id="+id+";";
			ArrayList<Good> goodsList=goodDAO.getDataBySql(sql);
			if(goodsList.size()==0) {
				System.out.println("该商品已经售罄，请选择其他商品");
				continue;
			}else{
				Good good=goodsList.get(0);//获取查询到的商品信息
				goodService.addAndMinusStock(good, count*-1);//减库存
				System.out.println("----您购买的商品名称："+good.getName()+"商品单价（元）:"+good.getPrice()+"");
				double amount=count*good.getPrice();//购买该商品的总价
				totalAmount+=amount;
				totalCount+=count;
				System.out.println("---输入1继续添加  ----2结算----3取消");
				int c=s.nextInt();
				if(c==1) {
					continue;
				}else if(c==2) {
					Order o=new Order();//新建订单
					o.setAmount(totalAmount);
					o.setCount(totalCount);
					o.setTime(DatetimeUtil.getNow());
					boolean result=addOrder(o);//添加订单
					System.out.println("------------------------------------------");
					if(!result) {
						totalAmount=0;
						totalCount=0;
						continue;	
					}else {
						System.out.println("----您购买的总数量："+totalCount+",总金额："+totalAmount+"。");
					}
					break;
				}else {
					totalAmount=0;
					totalCount=0;
					System.out.println("------------------------------------------");
					continue;
				}			
			}
		}
	}
}
