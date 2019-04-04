package com.lxhf.bean;

import java.util.List;


public class Orders {
	private Integer id;
	private String ordername;
	private int num;
	private float money;
	private int status;
	private Integer customerid;	
	private List<OrderItem> orderItems;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Integer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", ordernum=" + ordername + ", num=" + num + ", money=" + money + ", status=" + status
				+ ", customer=id" + customerid + ", orderItems=" + orderItems + "]";
	}

	
	
	
}
