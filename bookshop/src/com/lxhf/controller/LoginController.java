package com.lxhf.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxhf.bean.Customer;
import com.lxhf.service.CustomerService;

@Controller
public class LoginController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/Login")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping("/LoginController")
	public void login(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String message = "";
		HttpSession session = request.getSession();
		Customer customer = customerService.findOneCustomer(username, password);
		
		if(customer != null && customer.getStatus() == false)
		{
			
			if(customerService.updateCustomerStatus(customer,true)==true)
			{	
				Integer characterid = customer.getCharacterid();
				String character = customerService.findCustomerCharacter(characterid);
				if("user".equals(character)){				
				
					session.setAttribute("customer.id",customer.getId());
					session.setAttribute("customer",customer);
					response.sendRedirect(request.getContextPath()+"/listBook");
					return;
				}
				else if("manager".equals(character)){
					session.setAttribute("customer.id",customer.getId());
					session.setAttribute("customer",customer);
					session.setAttribute("managerFlag", "true");
			
					response.sendRedirect(request.getContextPath()+"/manager");
					return;
				}
			}
			else
			{
				message = "false";
				request.setAttribute("message", message);
			}
		}
		else if(customer != null && customer.getStatus() == true) {
			message = "online";
			request.setAttribute("message", message);
		}
		else if(customer == null) {
			message = "no";
			request.setAttribute("message", message);
		}
		request.getRequestDispatcher("Login").forward(request, response);
		return;
	}

	
}
