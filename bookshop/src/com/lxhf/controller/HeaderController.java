package com.lxhf.controller;

import java.util.List;

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
	public String welcomeheader1(){
		return "redirect:listBook";
	}
	
	@RequestMapping("/header")
	public String welcomeheader2(Model model){

		return "header";
	}
	
}
