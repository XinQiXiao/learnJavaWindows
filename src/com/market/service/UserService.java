package com.market.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.market.DAO.UserDao;
import com.market.pojo.User;

// ��д�û����ҵ�񷽷�
public class UserService {
	UserDao userDAO=new UserDao();
	
	// ��¼����
	public User login(){
		User u=null;
		Scanner s=new Scanner(System.in);
		System.out.println("�������û�����");
		String uname=s.next();
		System.out.println("���������룺");
		String upwd=s.next();
		String sql="select * from users where name='"+uname+"' and password='"+upwd+"'";
		ArrayList<User> usersList=userDAO.getDataBySql(sql);
		if(usersList.size()>0) {
			u=usersList.get(0);// ��ȡ��һ���û�
			System.out.println("-------------�û���¼�ɹ�����ӭ�㣺,"+u.getName()+"��");
		}else {
			System.out.println("-------------�û���¼ʧ��");
		}
		return u;
	}
}
