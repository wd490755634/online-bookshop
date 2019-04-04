package com.lxhf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxhf.bean.Customer;
import com.lxhf.service.CustomerService;


@Controller
public class RegistController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/regist")
	public String regit(){
		return "regist";
	}
	
	@RequestMapping("/RegistController")
	public void Regist(HttpServletRequest request,HttpServletResponse response) throws Exception{
			String message = null;
			String username = request.getParameter("username");
			Customer customer = customerService.findCustomerByUserName(username);
			if(customer != null){
				message = "exist";
				request.setAttribute("message", message);
			}else{
				String password = request.getParameter("password");
				String nickname = request.getParameter("nickname");
				String phonenum = request.getParameter("phonenum");
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				if(password!=""&&nickname!=""&&phonenum!=""&&email!=""&&address!=""&&(phonenum.length()==11)){
					Customer customer1 = new Customer();
					customer1.setUsername(username);
					customer1.setPassword(password);
					customer1.setNickname(nickname);
					customer1.setPhonenum(phonenum);
					customer1.setEmail(email);
					customer1.setAddress(address);
					customer1.setStatus(false);
					customerService.addCustomer(customer1);
					request.getRequestDispatcher("listBook").forward(request, response);
					return ;
				}
				else if(phonenum!=""&&(phonenum.length()!=11)) {
					message = "phoneillegal";
					request.setAttribute("message", message);
				}else {
					message = "paranull";
					request.setAttribute("message", message);
				}
			}
		request.getRequestDispatcher("regist").forward(request, response);
		return ;
	}
}
	

