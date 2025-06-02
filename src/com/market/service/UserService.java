package com.market.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.market.DAO.UserDao;
import com.market.pojo.User;

// 编写用户相关业务方法
public class UserService {
	UserDao userDAO=new UserDao();
	
	// 登录方法
	public User login(){
		User u=null;
		Scanner s=new Scanner(System.in);
		System.out.println("请输入用户名：");
		String uname=s.next();
		System.out.println("请输入密码：");
		String upwd=s.next();
		String sql="select * from users where name='"+uname+"' and password='"+upwd+"'";
		ArrayList<User> usersList=userDAO.getDataBySql(sql);
		if(usersList.size()>0) {
			u=usersList.get(0);// 获取第一个用户
			System.out.println("-------------用户登录成功，欢迎你：,"+u.getName()+"。");
		}else {
			System.out.println("-------------用户登录失败");
		}
		return u;
	}
}
