package com.lxhf.service;

import java.util.List;

import com.lxhf.bean.Book;
import com.lxhf.bean.Page;

public interface BookService {

	public List<Book> findBookAll();

	public void addBook(Book book);

	public void deleteBook(Integer id);

	public void updateBook(Book book);

	public Book getBookById(Integer id);

	public Page findPageBook(Integer page);

	public Page findPageCategory(Integer categoryId, Integer current);

	public void deleteBookByCategoryId(Integer categoryId);

	public Page findPageBookByName(String name, Integer current);

	public Page findPageBookByAuthor(String author, Integer current);

	public Page findPageBookByDesc(String desc, Integer current);

	public Page findPageBookByCName(String relatedField, Integer current);

	public Page findPageBookByCDesc(String relatedField, Integer current);

	public Page findPageBookByAll(String relatedField, Integer current);

	public Page findPageBookByPress(String relatedField, Integer current);

}
