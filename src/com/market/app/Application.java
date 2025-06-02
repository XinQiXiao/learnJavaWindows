package com.market.app;

import java.util.Scanner;

import com.market.pojo.User;
import com.market.service.GoodService;
import com.market.service.OrderService;
import com.market.service.UserService;


public class Application {
	
	static GoodService goodService=new GoodService();
	static OrderService orderService=new OrderService();
	static UserService userService=new UserService();
	static Scanner s=new Scanner(System.in);

	// 组合所有业务方法
	public static void go() {
		System.out.println("*********************超市管理系统**********************");
		User user=null;
		while(true) {
			user=userService.login();
			if(user!=null) {
				break;
			}
		}
		if(user!=null) {
			while(true) {
				System.out.println("---------------------主页----------------------");
				System.out.println("            1.收银");
				System.out.println("            2.商品列表");
				System.out.println("            3.商品上架");
				System.out.println("            4.商品下架");
				System.out.println("            5.库存设置");
				System.out.println("            6.价格设置");
				System.out.println("            7.订单列表");
				System.out.println("            8.删除订单");
				System.out.println("            9.退出系统");
				System.out.println("-------请输入功能编号：");
				int choice=s.nextInt();
				if(choice==1) {
					orderService.cashier();
				}else if(choice==2) {
					goodService.showAllGoods();
				}else if(choice==3) {
					if("admin".equals(user.getPermission())) {
						goodService.addGoods();
					}else {
						System.out.println("需要admin用户");
					}	
				}else if(choice==4) {
					if("admin".equals(user.getPermission())) {
						goodService.delGood();
					}else {
						System.out.println("需要admin用户");
					}
				}else if(choice==5) {
					if("admin".equals(user.getPermission())) {
						goodService.setStock();
					}else {
						System.out.println("需要admin用户");
					}
				}else if(choice==6) {
					if("admin".equals(user.getPermission())) {
						goodService.setPrice();
					}else {
						System.out.println("需要admin用户");
					}
				}else if(choice==7) {
					orderService.getAllOrders();
				}else if(choice==8) {
					if("admin".equals(user.getPermission())) {
						orderService.delOrder();
					}else {
						System.out.println("需要admin用户");
					}
				}else if(choice==9) {
					System.out.println("-------------------谢谢惠顾-------------------");
					break;
				}else {
					System.out.println("没有此功能请重新输入");
				}
				continue;
			}
		}
	}

}
