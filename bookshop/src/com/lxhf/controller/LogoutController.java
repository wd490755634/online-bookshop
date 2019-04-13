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
public class LogoutController {

		@Autowired
		private CustomerService customerService;
		
		
		@RequestMapping("/LogoutController")
		public void logout(HttpServletRequest request,HttpServletResponse response) throws Exception{
			HttpSession session = request.getSession();
			Integer id = (Integer) request.getSession().getAttribute("customer.id");
			Customer customer = customerService.findCustomer(id);
			String message = null;
			if(customerService.updateCustomerStatus(customer, false)!=null&&session.getAttribute("managerFlag")==null)
			{
				session.setAttribute("customer", null);
				session.setAttribute("customer.id", null);
				session.setAttribute("managerFlag", null);
			}
			if(customerService.updateCustomerStatus(customer, false)!=null&&session.getAttribute("managerFlag")!=null)
			{
				session.setAttribute("customer", null);
				session.setAttribute("customer.id", null);
				session.setAttribute("managerFlag", null);
			}
			else if(customerService.updateCustomerStatus(customer, false)==null&&session.getAttribute("managerFlag")==null)
			{	
				message = "logfalse";
				session.setAttribute("message", message);
			}
			else if(customerService.updateCustomerStatus(customer, false)==null&&session.getAttribute("managerFlag")!=null) {
				message = "logfalse";
				request.setAttribute("message", message);
				request.getRequestDispatcher("manager").forward(request, response);
				return;
			}
			response.sendRedirect(request.getContextPath()+"/listBook");
			return;
		}
}
