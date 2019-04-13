package com.lxhf.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxhf.bean.Category;
import com.lxhf.service.CategoryService;


@Controller
public class HeaderController {
	
	@RequestMapping("/")
	public void welcomeheader1(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("listBook").forward(request, response);
	}
	
}
