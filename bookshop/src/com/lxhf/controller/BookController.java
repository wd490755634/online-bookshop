package com.lxhf.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.lxhf.bean.Book;
import com.lxhf.bean.Category;
import com.lxhf.bean.Page;
import com.lxhf.service.BookService;
import com.lxhf.service.CategoryService;

@Transactional
@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private CategoryService categoryService;

	
	@RequestMapping("manager/QueryBookController")
	public String findBookIndex(Integer pageNum, Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("managerFlag") == null) {
			return "login";
		}
		System.out.println("**********" + pageNum);
		Page page = bookService.findPageBook(pageNum);
		
		
		
		System.out.println(page);
		model.addAttribute("page", page);
		return "manager/showBooks";
	}
	
	@RequestMapping("manager/addBook")
	public String addsBookIndex(Model model, HttpServletRequest request){

		if (request.getSession().getAttribute("managerFlag") == null) {
			return "login";
		}
		List<Category> categorys = categoryService.findCategoryAll();
		model.addAttribute("categorys", categorys);
		return "manager/listBook";
	}
	
	@RequestMapping("manager/AddBookController")
	public String addsBook(HttpServletRequest request, Book book, Integer categoryId, MultipartFile picture_b, MultipartFile picture_w) throws IllegalStateException, IOException{

		if (request.getSession().getAttribute("managerFlag") == null) {
			return "login";
		}
		String pictureFile_name =  picture_b.getOriginalFilename();
		System.out.println("####################categoryid" + categoryId);
		if(pictureFile_name == null|| pictureFile_name.equals("")){
	        //have no small picture
	    }else{
	    	String path=request.getSession().getServletContext().getRealPath("/image") ;
			String newFileName = UUID.randomUUID().toString()+pictureFile_name.substring(pictureFile_name.lastIndexOf("."));
			File uploadPic = new java.io.File(path + "/"+newFileName);
			if(!uploadPic.exists()){
				uploadPic.mkdirs();
			}
			picture_b.transferTo(uploadPic);
			book.setImage_b("/image/"+newFileName);	
	    }
		
		String image_w_name =  picture_w.getOriginalFilename();
		System.out.println("####################categoryid" + categoryId);
		if(image_w_name == null|| image_w_name.equals("")){
	        //have no big picture
	    }else{
	    	String path=request.getSession().getServletContext().getRealPath("/image") ;
			String newFileName = UUID.randomUUID().toString()+image_w_name.substring(image_w_name.lastIndexOf("."));
			File uploadPic = new java.io.File(path + "/"+newFileName);
			if(!uploadPic.exists()){
				uploadPic.mkdirs();
			}
			picture_w.transferTo(uploadPic);
			book.setImage_w("/image/"+newFileName);	
	    }
		
		book.setCurrprice(book.getPrice() * book.getDiscount() / 10);
		
		Category category = categoryService.getCategoryById(categoryId);
		book.setCategory(category);
		
		System.out.println("===============" + book);
		bookService.addBook(book);
		return "redirect:addBook";
	}
	
	@RequestMapping("manager/deleteBook")
	public String deleteBook(Integer bookId, HttpServletRequest request) {

		if (request.getSession().getAttribute("managerFlag") == null) {
			return "login";
		}
		bookService.deleteBook(bookId);
		return "redirect:QueryBookController?pageNum=1";
	}
	
	@RequestMapping("manager/updateBookIndex")
	public String updateBookIndex(Integer bookId, Model model, HttpServletRequest request) {

		if (request.getSession().getAttribute("managerFlag") == null) {
			return "login";
		}
		List<Category> categorys = categoryService.findCategoryAll();
		model.addAttribute("categorys", categorys);
		Book book = bookService.getBookById(bookId);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + book);
		model.addAttribute("book",book);
		return "manager/updateBook";
	}
	
	@RequestMapping("manager/updateBook")
	public String updateBook(HttpServletRequest request, Book book, Integer categoryId, MultipartFile picture_b, MultipartFile picture_w) throws IllegalStateException, IOException {

		if (request.getSession().getAttribute("managerFlag") == null) {
			return "login";
		}

		String pictureFile_name =  picture_b.getOriginalFilename();
		if(pictureFile_name == null|| pictureFile_name.equals("")){
	        //have no small picture
	    }else{
	    	String path=request.getSession().getServletContext().getRealPath("/image") ;
			String newFileName = UUID.randomUUID().toString()+pictureFile_name.substring(pictureFile_name.lastIndexOf("."));
			File uploadPic = new java.io.File(path + "/"+newFileName);
			if(!uploadPic.exists()){
				uploadPic.mkdirs();
			}
			picture_b.transferTo(uploadPic);
			book.setImage_b("/image/"+newFileName);	
	    }
		
		String image_w_name =  picture_w.getOriginalFilename();
		if(image_w_name == null|| image_w_name.equals("")){
	        //have no big picture
	    }else{
	    	String path=request.getSession().getServletContext().getRealPath("/image") ;
			String newFileName = UUID.randomUUID().toString()+image_w_name.substring(image_w_name.lastIndexOf("."));
			File uploadPic = new java.io.File(path + "/"+newFileName);
			if(!uploadPic.exists()){
				uploadPic.mkdirs();
			}
			picture_w.transferTo(uploadPic);
			book.setImage_w("/image/"+newFileName);	
	    }
		
		book.setCurrprice(book.getPrice() * book.getDiscount() / 10);
		Category category = categoryService.getCategoryById(categoryId);
		book.setCategory(category);		
		bookService.updateBook(book);
		return "redirect:QueryBookController?pageNum=1";
	}
	
	@RequestMapping("manager/showBookDetail")
	public String showManagerBookDetail(Integer bookId, Model model){
		Book book = bookService.getBookById(bookId);
		model.addAttribute("book", book);
		return "manager/detail";
	}
	
	//====================user interface=======================================//
	@RequestMapping("listBook")
	public String showClientIndex(Model model, Integer current) throws ServletException, IOException{
	
		List<Category> list = categoryService.findCategoryAll();
		if (current == null) {
			current = 1;
		}
		Page page = bookService.findPageBook(current);	
		model.addAttribute("page", page);
		model.addAttribute("categorys", list);
//		request.getSession().setAttribute("categorys", list);
//		request.getSession().setAttribute("page", page);
//		request.getRequestDispatcher("listBook").forward(request, response);
//		System.out.println("6666666666666666" + page);
		return "listBook";
	}
	
	@RequestMapping("client/ShowController")
	public String showClient(Integer current, Model model) throws ServletException, IOException{

		System.out.println("88888888888888888" + current);
		List<Category> list = categoryService.findCategoryAll();
		Page page = bookService.findPageBook(current);	
		model.addAttribute("page", page);
		model.addAttribute("categorys", list);
		/*request.getSession().setAttribute("categorys", list);
		request.getSession().setAttribute("page", page);
		
		request.getRequestDispatcher("listBook").forward(request, response);*/
		System.out.println(page);
		return "listBook";
	}
	
	@RequestMapping("CategoryPageController")
	public String getCategoryIndex(Model model, Integer categoryId, Integer current, HttpServletRequest request){

		Page page = bookService.findPageCategory(categoryId,Integer.valueOf(current));
		
		System.out.println(" ###################################!!!!!" + page);
		model.addAttribute("page", page);
		//����Ҫ�����з��������Ϣ
		List<Category> categorys = categoryService.findCategoryAll();
		model.addAttribute("categorys", categorys);
		
		return "categoryPage";
	}
	
	@RequestMapping("search")
	public String searchBook(String relatedField, Integer current, Model model, String field, String manager){
		if (current == null) {
			current = 1;
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!" + relatedField + field + current);
//		Set<Book> setbooks = new HashSet<Book>();
//		List<Book> books = new ArrayList<Book>();
//		books.addAll(setbooks);

		switch (field) {
		case "all":
			Page pageAll = bookService.findPageBookByAll(relatedField, current);
			model.addAttribute("page", pageAll);
			break;
		case "bookName":
			Page pageName = bookService.findPageBookByName(relatedField, current);
			model.addAttribute("page", pageName);
			break;
		case "bookAuthor":
			Page pageAuthor = bookService.findPageBookByAuthor(relatedField, current);
			model.addAttribute("page", pageAuthor);
			break;
		case "bookDesc":
			Page pageDesc = bookService.findPageBookByDesc(relatedField, current);
			model.addAttribute("page", pageDesc);
			break;
		case "categoryName":
			Page pageCName = bookService.findPageBookByCName(relatedField, current);
			model.addAttribute("page", pageCName);
			break;
		case "categoryDesc":
			Page pageCDesc = bookService.findPageBookByCDesc(relatedField, current);
			model.addAttribute("page", pageCDesc);
			break;
		case "press":
			Page pagePress = bookService.findPageBookByPress(relatedField, current);
			model.addAttribute("page", pagePress);
		default:
			break;
		}
		
		
		List<Category> categorys = categoryService.findCategoryAll();
		model.addAttribute("categorys", categorys);
		
		model.addAttribute("relatedField", relatedField);
		model.addAttribute("field", field);
		if(manager != null){
			return "manager/showBooks";
		}
		return "searchPage";
	}
	
	@RequestMapping("showDetail")
	public String showBookDetail(Integer id, Model model){
		Book book = bookService.getBookById(id);
		model.addAttribute("book", book);
		return "desc";
	}
	

}
