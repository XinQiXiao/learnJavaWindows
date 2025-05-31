package com.market.service;

import java.util.ArrayList;
import java.util.Scanner;
import com.market.DAO.GoodDao;
import com.market.pojo.Good;

// ��д��Ʒ���ҵ�񷽷�
public class GoodService {
	
	GoodDao goodDAO=new GoodDao();
	
	// չʾ������Ʒ
	public void showAllGoods() {
		String sql="select * from goods;";
		ArrayList<Good> goodsList=goodDAO.getDataBySql(sql);
		System.out.println("---------------------��Ʒ�б�---------------------");
		for(Good good:goodsList) {
			System.out.println(good.getId()+"   "+good.getName()+"   "+good.getPrice()+"   "+good.getStock());
		}
		System.out.println("---------------------------");
	} 
	
	// ��Ʒ�ϼ�
	public void addGoods() {
		
		Scanner s=new Scanner(System.in);
		System.out.println("���������ӵ���Ʒ���ƣ�");
		String name=s.next();
		System.out.println("���������ӵ���Ʒ�۸�");
		double price=s.nextDouble();
		String sql="insert into goods(name,price) values('"+name+"',"+price+");";
		boolean result=goodDAO.setDataBySql(sql);
		if (result) {
			System.out.println("-----��ӳɹ�");
		}else {
			System.out.println("------���ʧ��");
		}
	}
	
	// ��Ʒ�¼�
	public void delGood() {
	
		Scanner s=new Scanner(System.in);
		System.out.println("������Ҫ�¼ܵ���Ʒid:");
		int id=s.nextInt();
		
		String sql="delete from goods where id="+id+";";
		boolean result=goodDAO.setDataBySql(sql);
		if (result) {
			System.out.println("-----ɾ���ɹ�");
		}else {
			System.out.println("------ɾ��ʧ��");
		}
	}
	
	// ��Ʒ�۸��޸�
	public void setPrice() {
		
		Scanner s=new Scanner(System.in);
		System.out.println("������Ҫ�޸ļ۸����Ʒid:");
		int id=s.nextInt();
		System.out.println("�������޸ĺ�ļ۸�");
		double newPrice=s.nextDouble();
		String sql="update goods set price="+newPrice+" where id="+id+";";
		boolean result=goodDAO.setDataBySql(sql);
		if (result) {
			System.out.println("-----�޸ĳɹ�");
		}else {
			System.out.println("------�޸�ʧ��");
		}
	}
	
	// �޸�����
	public void setStock() {
		
		Scanner s=new Scanner(System.in);
		System.out.println("������Ҫ�޸Ŀ������Ʒ��id:");
		int id=s.nextInt();
		System.out.println("�������޸ĺ�Ŀ����");
		int stock=s.nextInt();
		if(stock>=0) {
			String sql="update goods set stock="+stock+" where id="+id+";";
			boolean result=goodDAO.setDataBySql(sql);
			if (result) {
				System.out.println("-----�޸ĳɹ�");
			}else {
				System.out.println("------�޸�ʧ��");
			}
		}else {
			System.out.println("-----������������0");
		}
		
	}
	
}
