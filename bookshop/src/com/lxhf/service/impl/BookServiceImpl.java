package com.lxhf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxhf.constants.Constants;
import com.lxhf.bean.Book;
import com.lxhf.bean.Page;
import com.lxhf.mapper.BookMapper;
import com.lxhf.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;

	@Override
	public List<Book> findBookAll() {
		return bookMapper.findBookAll();
	}

	@Override
	public void addBook(Book book) {
		bookMapper.addBook(book);

	}

	@Override
	public void deleteBook(Integer id) {
		bookMapper.deleteBook(id);
	}

	@Override
	public void deleteBookByCategoryId(Integer categoryId) {
		bookMapper.deleteBookByCategoryId(categoryId);
	}

	@Override
	public void updateBook(Book book) {

		bookMapper.updateBook(book);
	}

	@Override
	public Book getBookById(Integer id) {
		return bookMapper.getBookById(id);
	}

	@Override
	public Page findPageBook(Integer current) {

		int count = bookMapper.getCount();
		int totalPage = count % Constants.PAGESIZE == 0 ? count / Constants.PAGESIZE
				: count / Constants.PAGESIZE + 1;

		List<Book> books = bookMapper.findPage((current - 1) * Constants.PAGESIZE, Constants.PAGESIZE);
		Page page = new Page(totalPage, books);

		return page;
		
	}

	@Override
	public Page findPageCategory(Integer categoryId, Integer current) {

		int categoryCount = bookMapper.getCategoryCount(categoryId);
		// totalPage 总页数
		int totalPage = categoryCount % Constants.CATEGORYPAGESIZE == 0 ? categoryCount / Constants.CATEGORYPAGESIZE
				: categoryCount / Constants.CATEGORYPAGESIZE + 1;

		List<Book> books = bookMapper.findPageCategory(categoryId, (current - 1) * Constants.CATEGORYPAGESIZE,
				Constants.CATEGORYPAGESIZE);


		Page page = new Page(totalPage, books);

		return page;
	}

	@Override
	public Page findPageBookByName(String name, Integer current) {
		int nameCount = bookMapper.getNameCount(name);
		int totalPage = nameCount % Constants.PAGESIZE == 0 ? nameCount / Constants.PAGESIZE
				: nameCount / Constants.PAGESIZE + 1;

		List<Book> books = bookMapper.findPageBookByName(name, (current - 1) * Constants.PAGESIZE, Constants.PAGESIZE);
		Page page = new Page(totalPage, books);

		return page;
	}

	@Override
	public Page findPageBookByAuthor(String author, Integer current) {
		int authorCount = bookMapper.getAuthorCount(author);
		int totalPage = authorCount % Constants.PAGESIZE == 0 ? authorCount / Constants.PAGESIZE
				: authorCount / Constants.PAGESIZE + 1;

		List<Book> books = bookMapper.findPageBookByAuthor(author, (current - 1) * Constants.PAGESIZE,
				Constants.PAGESIZE);
		Page page = new Page(totalPage, books);

		return page;
	}

	@Override
	public Page findPageBookByDesc(String desc, Integer current) {
		int descCount = bookMapper.getDescCount(desc);
		int totalPage = descCount % Constants.PAGESIZE == 0 ? descCount / Constants.PAGESIZE
				: descCount / Constants.PAGESIZE + 1;

		List<Book> books = bookMapper.findPageBookByDesc(desc, (current - 1) * Constants.PAGESIZE, Constants.PAGESIZE);
		Page page = new Page(totalPage, books);

		return page;
	}

	@Override
	public Page findPageBookByCName(String relatedField, Integer current) {
		int cNameCount = bookMapper.getCNameCount(relatedField);
		int totalPage = cNameCount % Constants.PAGESIZE == 0 ? cNameCount / Constants.PAGESIZE
				: cNameCount / Constants.PAGESIZE + 1;

		List<Book> books = bookMapper.findPageBookByCName(relatedField, (current - 1) * Constants.PAGESIZE,
				Constants.PAGESIZE);
		Page page = new Page(totalPage, books);

		return page;
	}

	@Override
	public Page findPageBookByCDesc(String relatedField, Integer current) {
		int cDescCount = bookMapper.getCDescCount(relatedField);
		int totalPage = cDescCount % Constants.PAGESIZE == 0 ? cDescCount / Constants.PAGESIZE
				: cDescCount / Constants.PAGESIZE + 1;

		List<Book> books = bookMapper.findPageBookByCDesc(relatedField, (current - 1) * Constants.PAGESIZE,
				Constants.PAGESIZE);
		Page page = new Page(totalPage, books);
		return page;
	}

	@Override
	public Page findPageBookByAll(String relatedField, Integer current) {
		int allCount = bookMapper.getAllCount(relatedField);
		int totalPage = allCount % Constants.PAGESIZE == 0 ? allCount / Constants.PAGESIZE
				: allCount / Constants.PAGESIZE + 1;

		List<Book> books = bookMapper.findPageBookByAll(relatedField, (current - 1) * Constants.PAGESIZE,
				Constants.PAGESIZE);
		Page page = new Page(totalPage, books);

		return page;
	}
	
	@Override
	public Page findPageBookByPress(String relatedField, Integer current) {
		int pageCount = bookMapper.getPressCount(relatedField);
		int totalPage = pageCount % Constants.PAGESIZE == 0 ? pageCount / Constants.PAGESIZE
				: pageCount / Constants.PAGESIZE + 1;

		List<Book> books = bookMapper.findPageBookByPress(relatedField, (current - 1) * Constants.PAGESIZE,
				Constants.PAGESIZE);
		Page page = new Page(totalPage, books);

		return page;
	}
}
