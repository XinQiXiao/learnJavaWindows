package com.market.pojo;

import java.sql.Timestamp;

public class Order {
	private int id;
	private int count;
	private double amount;
	private Timestamp time; 
	
	public Order() {
		super();
	}
	public Order(int id, int count, double amount, Timestamp time) {
		super();
		this.id = id;
		this.count = count;
		this.amount = amount;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
