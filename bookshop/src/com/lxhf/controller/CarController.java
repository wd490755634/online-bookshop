package com.lxhf.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxhf.bean.Book;
import com.lxhf.bean.Car;
import com.lxhf.bean.CarItem;
import com.lxhf.service.BookService;
import com.lxhf.service.CarService;


@Controller
public class CarController {

	@Autowired
	BookService bookService;
	
	@Autowired
	CarService carService;
	
	//enter car
	@RequestMapping("/showCar")
	public String showCar(HttpServletRequest request,HttpServletResponse response ,Model model) throws ServletException, IOException{
		Integer customerid = (Integer)request.getSession().getAttribute("customer.id");
		if(customerid==null)
		{
			return "login";		
		}
		else {
			List<CarItem> list = carService.findCarItemByCustomerId(customerid);
			Car car = new Car();
			car.setCarItems(list);
			model.addAttribute("car",car);
			model.addAttribute("customerid", customerid);
			return "showCar";
		}
		
	}
	
	//add into car
	@RequestMapping("/BuyController")
	public void addCar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Integer bookid = Integer.valueOf(request.getParameter("bookId"));
		Integer customerid = (Integer) request.getSession().getAttribute("customer.id");
		Integer quantity = Integer.valueOf(request.getParameter("quantity"));
		if(request.getSession().getAttribute("customer")==null){
			request.getRequestDispatcher("listBook").forward(request, response);
			return;
		}
		else{
			Book book = bookService.getBookById(bookid);
			CarItem carItem = carService.findCarItemByIdandCustomerId(book.getId(),customerid);
			if(carItem==null){
				CarItem carItemnew = new CarItem();
				carItemnew.setBookid(bookid);
				carItemnew.setCustomerid(customerid);
				carItemnew.setMoney(book.getCurrprice()*quantity);
				carItemnew.setNum(quantity);
				carService.insertCarItem(carItemnew);

			}
			else{
				float money = book.getCurrprice();
				carService.updateCarItemNumandMoney(carItem.getId(),carItem.getMoney()+money*quantity,carItem.getNum()+quantity);
			}
		}
		request.getRequestDispatcher("listBook").forward(request, response);
		return;
	}
	
	@RequestMapping("DeleteCarItem")
	public String deleteItem(HttpServletRequest request , HttpServletResponse response) {
		Integer caritemid = Integer.valueOf(request.getParameter("caritemid"));
		if(caritemid!=null) {
			carService.deleteCarItemById(caritemid);
		}
		
		return "redirect:/showCar";
	}
	
}
