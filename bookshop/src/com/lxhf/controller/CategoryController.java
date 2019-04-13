package com.lxhf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxhf.bean.Category;
import com.lxhf.bean.Page;
import com.lxhf.service.BookService;
import com.lxhf.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	BookService bookService;

	@RequestMapping("manager/index")
	public String showIndex(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("managerFlag") == null) {
			return "login";
		}
		return "manager/index";
	}

	@RequestMapping("manager")
	public String addCatelogIndex(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("managerFlag") == null) {
			return "login";
		}
		return "manager/index";
	}

	@RequestMapping("manager/QueryController")
	public String queryCatalog(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("managerFlag") == null) {
			return "login";
		}
		List<Category> list = categoryService.findCategoryAll();
		model.addAttribute("categorys", list);
		return "manager/listCategory";
	}

	@RequestMapping("manager/addcategory")
	public String addCategory(Category category, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("managerFlag") == null) {
			return "login";
		}
		categoryService.addCategory(category);
		return "manager/index";
	}

	@RequestMapping("manager/updateCategoryIndex")
	public String updateCategoryIndex(Integer categoryId, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("managerFlag") == null) {
			return "login";
		}
		Category category = categoryService.getCategoryById(categoryId);
		model.addAttribute("category", category);
		return "manager/updateCategory";
	}

	@RequestMapping("manager/updateCategory")
	public String updateCategory(Category category, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("managerFlag") == null) {
			return "login";
		}
		categoryService.updateCategory(category);
		return "redirect:QueryController";
	}

	@RequestMapping("manager/deleteCategory")
	public String deleteCategory(Integer categoryId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("managerFlag") == null) {
			return "login";
		}
		bookService.deleteBookByCategoryId(categoryId);
		categoryService.deleteCategory(categoryId);
		return "redirect:QueryController";
	}

	@RequestMapping("manager/searchCategory")
	public String findCategory(String relatedField, Model model, String field, HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("managerFlag") == null) {
			return "login";
		}
		
		switch (field) {
		case "all":
			List<Category> categorysAll = categoryService.findCategoryByAll(relatedField);
			model.addAttribute("categorys", categorysAll);
			break;
		case "categoryName":
			List<Category> categorysName = categoryService.findCategoryByName(relatedField);
			model.addAttribute("categorys", categorysName);
			break;
		case "categoryDesc":
			List<Category> categorysDesc = categoryService.findCategoryByDesc(relatedField);
			model.addAttribute("categorys", categorysDesc);
			break;
		default:
			break;
		}
		model.addAttribute("relatedField", relatedField);
		model.addAttribute("field", field);
			
		return "manager/listCategory";
	}

	
}
