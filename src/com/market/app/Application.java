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

	// �������ҵ�񷽷�
	public static void go() {
		System.out.println("*********************���й���ϵͳ**********************");
		User user=null;
		while(true) {
			user=userService.login();
			if(user!=null) {
				break;
			}
		}
		if(user!=null) {
			while(true) {
				System.out.println("---------------------��ҳ----------------------");
				System.out.println("            1.����");
				System.out.println("            2.��Ʒ�б�");
				System.out.println("            3.��Ʒ�ϼ�");
				System.out.println("            4.��Ʒ�¼�");
				System.out.println("            5.�������");
				System.out.println("            6.�۸�����");
				System.out.println("            7.�����б�");
				System.out.println("            8.ɾ������");
				System.out.println("            9.�˳�ϵͳ");
				System.out.println("-------�����빦�ܱ�ţ�");
				int choice=s.nextInt();
				if(choice==1) {
					orderService.cashier();
				}else if(choice==2) {
					goodService.showAllGoods();
				}else if(choice==3) {
					if("admin".equals(user.getPermission())) {
						goodService.addGoods();
					}else {
						System.out.println("��Ҫadmin�û�");
					}	
				}else if(choice==4) {
					if("admin".equals(user.getPermission())) {
						goodService.delGood();
					}else {
						System.out.println("��Ҫadmin�û�");
					}
				}else if(choice==5) {
					if("admin".equals(user.getPermission())) {
						goodService.setStock();
					}else {
						System.out.println("��Ҫadmin�û�");
					}
				}else if(choice==6) {
					if("admin".equals(user.getPermission())) {
						goodService.setPrice();
					}else {
						System.out.println("��Ҫadmin�û�");
					}
				}else if(choice==7) {
					orderService.getAllOrders();
				}else if(choice==8) {
					if("admin".equals(user.getPermission())) {
						orderService.delOrder();
					}else {
						System.out.println("��Ҫadmin�û�");
					}
				}else if(choice==9) {
					System.out.println("-------------------лл�ݹ�-------------------");
					break;
				}else {
					System.out.println("û�д˹�������������");
				}
				continue;
			}
		}
	}

}
