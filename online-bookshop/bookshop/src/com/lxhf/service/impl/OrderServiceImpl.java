package com.lxhf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxhf.bean.Orders;
import com.lxhf.bean.OrderItem;
import com.lxhf.mapper.OrderMapper;
import com.lxhf.service.OrderService;


@Transactional
@Service
public class OrderServiceImpl implements OrderService {

	//insert order by order
	@Autowired
	OrderMapper orderMapper;
	@Override
	public void insertOneOrder(Orders order) {
		orderMapper.insertOrder(order);
		
	}
	
	//find current order's orderid
	@Override
	public Integer findOrderIdByOrdername(String ordername) {
		Integer orderid = orderMapper.findIdByOrdername(ordername);
		if(orderid!=0)
			return orderid;
		return 0;
	}

	//insert into orderitem
	@Override
	public void insertOneOrderItem(OrderItem orderItem) {
		orderMapper.insertOrderItem(orderItem);
		
	}

	//find order by customerid
	@Override
	public List<Orders> findOrderIdByCustomerId(Integer customerid) {
		List<Orders> list = orderMapper.findOrderByCustomeiId(customerid);
		if(list!=null)
			return list;
		return null;
	}
	
	@Override
	public void updateStatusById(Integer id) {
		orderMapper.updateOrderStatusById(id);
		
	}


}
