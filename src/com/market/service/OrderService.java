package com.market.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.market.DAO.GoodDao;
import com.market.DAO.OrderDao;
import com.market.pojo.Good;
import com.market.pojo.Order;
import com.market.util.DatetimeUtil;

// ��д����ҵ��
public class OrderService {
	OrderDao orderDAO=new OrderDao();
	GoodDao goodDAO=new GoodDao();
	Scanner s=new Scanner(System.in);
	GoodService goodService=new GoodService();
	
	// ��ȡ���ж���
	public void getAllOrders() {
		String sql="select * from orders;";
		ArrayList<Order> ordersList=orderDAO.getDataBySql(sql);
		System.out.println("---------------------���ж����б�---------------------");
		for(Order order:ordersList) {
			System.out.println(order.getId()+"    "+order.getCount()+"    "+
			order.getAmount()+"    "+order.getTime());
		}
		System.out.println("---------------------------------------------");
	}
	
	// ��Ӷ���
	public boolean addOrder(Order order) {
		String sql="insert into orders(count,amount,time) values("+order.getCount()+","+order.getAmount()+",'"+order.getTime()+"');";
		//System.out.println("addOrderSql:"+sql);
		boolean result=orderDAO.setDataBySql(sql);
		if(result) {
			System.out.println("-----��Ӷ����ɹ�");
		}else {
			System.out.println("-----��Ӷ���ʧ��");
		}
		return result;
	}
	
	// ɾ������
	public void delOrder() {
		System.out.println("---------------------ɾ������---------------------");
		Scanner s=new Scanner(System.in);
		System.out.println("������Ҫɾ������id:");
		int id=s.nextInt();
		
		String sql="delete from orders where id="+id+";";
		boolean result=goodDAO.setDataBySql(sql);
		if (result) {
			System.out.println("-----ɾ�������ɹ�");
		}else {
			System.out.println("------ɾ������ʧ��");
		}
	}
	
	// ����̨
	public void cashier() {
		int totalCount=0;// �û������ܼ���
		double totalAmount=0;// �û������ܽ��
		System.out.println("---------------------����̨---------------------");
		while(true) {
			System.out.println("��������Ʒid:");
			int id=s.nextInt();
			System.out.println("�����빴ѡ������");
			int count=s.nextInt();
			String sql="select * from goods where id="+id+";";
			ArrayList<Good> goodsList=goodDAO.getDataBySql(sql);
			if(goodsList.size()==0) {
				System.out.println("����Ʒ�Ѿ���������ѡ��������Ʒ");
				continue;
			}else{
				Good good=goodsList.get(0);//��ȡ��ѯ������Ʒ��Ϣ
				goodService.addAndMinusStock(good, count*-1);//�����
				System.out.println("----���������Ʒ���ƣ�"+good.getName()+"��Ʒ���ۣ�Ԫ��:"+good.getPrice()+"");
				double amount=count*good.getPrice();//�������Ʒ���ܼ�
				totalAmount+=amount;
				totalCount+=count;
				System.out.println("---����1�������  ----2����----3ȡ��");
				int c=s.nextInt();
				if(c==1) {
					continue;
				}else if(c==2) {
					Order o=new Order();//�½�����
					o.setAmount(totalAmount);
					o.setCount(totalCount);
					o.setTime(DatetimeUtil.getNow());
					boolean result=addOrder(o);//��Ӷ���
					System.out.println("------------------------------------------");
					if(!result) {
						totalAmount=0;
						totalCount=0;
						continue;	
					}else {
						System.out.println("----���������������"+totalCount+",�ܽ�"+totalAmount+"��");
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
