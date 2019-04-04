package com.lxhf.mapper;

import com.lxhf.bean.Orders;

import java.util.List;

import com.lxhf.bean.OrderItem;

public interface OrderMapper {

	public void insertOrder(Orders order);

	public Integer findIdByOrdername(String ordername);

	public void insertOrderItem(OrderItem orderItem);

	public List<Orders> findOrderByCustomeiId(Integer customerid);
	
	public void updateOrderStatusById(Integer id);

}
