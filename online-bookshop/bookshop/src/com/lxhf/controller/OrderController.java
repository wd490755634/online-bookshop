package com.lxhf.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxhf.bean.Book;
import com.lxhf.bean.CarItem;
import com.lxhf.bean.Orders;
import com.lxhf.bean.OrderItem;
import com.lxhf.service.BookService;
import com.lxhf.service.CarService;
import com.lxhf.service.OrderService;


@Transactional(rollbackFor = Exception.class)
@Controller
public class OrderController {

	@Autowired
	CarService carService;

	@Autowired
	OrderService orderService;

	@Autowired
	BookService bookService;

	//car's balance
	@RequestMapping("/OrderController")
	public void payorder(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String op = request.getParameter("op");
		if("order".equals(op)){
			Integer customerid = (Integer) request.getSession().getAttribute("customer.id");
			Integer num = Integer.valueOf(request.getParameter("num"));
			float money = Float.valueOf(request.getParameter("money"));
			Orders order = new Orders();
			order.setOrdername(UUID.randomUUID().toString());
			order.setNum(num);
			order.setMoney(money);
			order.setCustomerid(customerid);
			order.setStatus(0);
			orderService.insertOneOrder(order);
			Integer orderid=orderService.findOrderIdByOrdername(order.getOrdername());
			if(orderid!=0){
				List<CarItem> caritems = carService.findCarItemByCustomerId(customerid);
				List<OrderItem> orderitems = new ArrayList<OrderItem>();
				for(CarItem carItem:caritems){
					OrderItem orderItem = new OrderItem();
					orderItem.setNum(carItem.getNum());
					orderItem.setPrice(carItem.getMoney());
					orderItem.setBookid(carItem.getBookid());
					orderItem.setOrderid(orderid);
					orderItem.setCustomerid(customerid);
					orderitems.add(orderItem);
				}
				for(OrderItem orderItem:orderitems){
					orderService.insertOneOrderItem(orderItem);
				}
				carService.deleteCarItemByCustomerId(customerid);
				request.getRequestDispatcher("listBook").forward(request, response);
				return;
			}
		}
	}

	//show order
	@RequestMapping("/showOrder")
	public String showOrder(HttpServletRequest request,HttpServletResponse response,Model model) throws ServletException, IOException{
		Integer customerid = (Integer)request.getSession().getAttribute("customer.id");
		if(customerid !=null){
			List<Orders> list =  orderService.findOrderIdByCustomerId(customerid);
			for(Orders order : list){
				for(OrderItem orderitem:order.getOrderItems()){
					Book book = new Book();
					book=bookService.getBookById(orderitem.getBookid());
					orderitem.setBook(book);
				}
			}
			model.addAttribute("orders",list);
			return "order";
		}	
		return "login";
	}

	//pay order
	@RequestMapping("/PayOrderController")
	public String PayOrder(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Integer orderid = Integer.valueOf(request.getParameter("orderid"));
		if(orderid != null) {
			orderService.updateStatusById(orderid);
		}

		return "redirect:/showOrder";
	}
}
