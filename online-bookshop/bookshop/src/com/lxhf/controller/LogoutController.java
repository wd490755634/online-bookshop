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
public class LogoutController {

		@Autowired
		private CustomerService customerService;
		
		
		@RequestMapping("/logout")
		public void logout(HttpServletRequest request,HttpServletResponse response) throws Exception{
			Integer id = (Integer) request.getSession().getAttribute("customer.id");
			Customer customer = customerService.findCustomer(id);
			String message = null;
			if(customerService.updateCustomerStatus(customer, false)!=null)
			{
				request.getSession().setAttribute("customer", null);
				request.getSession().setAttribute("customer.id", null);
				request.getSession().setAttribute("managerFlag", null);
			}
			else
			{	
				message = "logfalse";
				request.setAttribute("message", message);
			}
			request.getRequestDispatcher("listBook").forward(request, response);
			return;
				
		}
}
