package com.lxhf.service;

import com.lxhf.bean.Orders;

import java.util.List;

import com.lxhf.bean.OrderItem;

public interface OrderService {
	public void insertOneOrder(Orders order);

	public Integer findOrderIdByOrdername(String ordername);
	
	public void insertOneOrderItem(OrderItem orderItem);

	public List<Orders> findOrderIdByCustomerId(Integer customerid);
	
	public void updateStatusById(Integer id);
}
