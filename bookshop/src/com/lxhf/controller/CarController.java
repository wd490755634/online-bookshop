package com.lxhf.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxhf.bean.Book;
import com.lxhf.bean.Car;
import com.lxhf.bean.CarItem;
import com.lxhf.constants.Constants;
import com.lxhf.service.BookService;
import com.lxhf.service.CarService;


@Controller
public class CarController {

	@Autowired
	BookService bookService;
	
	@Autowired
	CarService carService;
	
	//enter car
	@RequestMapping("/showMyCar")
	public String showCar(HttpServletRequest request,HttpServletResponse response ,Model model) throws ServletException, IOException{
		/*
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
		*/
		Integer customerid = (Integer)request.getSession().getAttribute("customer.id");
		HttpSession session = request.getSession();
		HashMap<Integer,Integer> caritemandnum = new HashMap<>();
		if(session.getAttribute("caritemandnum")!=null)
				caritemandnum = (HashMap<Integer,Integer>) session.getAttribute("caritemandnum");
		List<CarItem> list = carService.findCarItemByCustomerId(customerid);
		Car car = new Car();
		if(caritemandnum!=null) {
			for(Integer bookid:caritemandnum.keySet()) {
				Book book = bookService.getBookById(bookid);
				CarItem carItemnew = new CarItem();
				carItemnew.setId(bookid);
				carItemnew.setBook(book);
				carItemnew.setBookid(bookid);
				carItemnew.setCustomerid(customerid);
				carItemnew.setMoney(book.getCurrprice()*caritemandnum.get(bookid));
				carItemnew.setNum(caritemandnum.get(bookid));
				list.add(carItemnew);
			}
			car.setCarItems(list);
		}
		//model.addAttribute("car",car);
	
		request.getSession().setAttribute("car", car);
		request.getSession().setAttribute("customer.id", customerid);
		return "showCar";
	}
	
	//add into car
	@RequestMapping("/BuyController")
	public void addCar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		/*
		if(customerid==null){
			HttpSession session = request.getSession();
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
		*/
		Integer bookid = Integer.valueOf(request.getParameter("bookId"));
		Integer customerid = (Integer) request.getSession().getAttribute("customer.id");
		Integer quantity = Integer.valueOf(request.getParameter("quantity"));
		HttpSession session = request.getSession();
		HashMap<Integer,Integer> caritemandnum = new HashMap<>();
		String message = (String)request.getSession().getAttribute("message");
		if(session.getAttribute("caritemandnum")!=null)
			 caritemandnum = (HashMap<Integer,Integer>) session.getAttribute("caritemandnum");
		
		if(caritemandnum==null) {
			caritemandnum.put(bookid, quantity);
			session.setAttribute("caritemandnum", caritemandnum);
		}
		else if(caritemandnum!=null&&caritemandnum.size()<5) {
			if(caritemandnum.containsKey(bookid)) {
				caritemandnum.put(bookid, caritemandnum.get(bookid)+quantity);
			}
			else
				caritemandnum.put(bookid, quantity);
			session.setAttribute("caritemandnum", caritemandnum);
		}
		else {
			if(caritemandnum.containsKey(bookid)) {
				caritemandnum.put(bookid, caritemandnum.get(bookid)+quantity);
			}
			else {
				message = "overnum";
				request.setAttribute("message", message);
				request.getRequestDispatcher("showDetail?id="+bookid).forward(request, response);
				return;
			}
		}
		request.getRequestDispatcher("listBook").forward(request, response);
		return;
	}
	
	@RequestMapping("DeleteCarItem")
	public String deleteItem(HttpServletRequest request , HttpServletResponse response) {
		/*
		Integer caritemid = Integer.valueOf(request.getParameter("caritemid"));
		if(caritemid!=null) {
			carService.deleteCarItemById(caritemid);
		}
		
		return "redirect:/showCar";
		*/
		HttpSession session = request.getSession();
		HashMap<Integer,Integer> caritemandnum = (HashMap<Integer,Integer>) session.getAttribute("caritemandnum");
		Integer caritemid = Integer.valueOf(request.getParameter("caritemid"));
		caritemandnum.remove(caritemid);
		return "redirect:/showMyCar";
	}
	
}
