package com.market.pojo;

public class User {
	private int id;
	private String name;
	private String password;
	private String permission;
	
	
	public User() {
		super();
	}
	
	public User(int id, String name, String password, String permission) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.permission = permission;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
}
