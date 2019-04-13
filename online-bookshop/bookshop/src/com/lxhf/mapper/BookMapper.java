package com.lxhf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lxhf.bean.Book;

public interface BookMapper {

	public List<Book> findBookAll();

	public void addBook(Book book);

	public void deleteBook(Integer id);

	public void updateBook(Book book);

	public Book getBookById(Integer id);

	public int getCount();
	public List<Book> findPage(@Param("num") Integer pageNum, @Param("size") Integer pagesize);

	public List<Book> findPageCategory(@Param("categoryid") Integer categoryId, @Param("current") Integer current,
			@Param("size") Integer categorypagesize);

	public int getCategoryCount(Integer categoryId);

	public void deleteBookByCategoryId(Integer categoryId);

	public List<Book> findPageBookByName(@Param("name") String name, @Param("current") Integer current,
			@Param("size") Integer size);

	public int getNameCount(@Param("name") String name);

	public List<Book> findPageBookByAuthor(@Param("author") String author, @Param("current") Integer current,
			@Param("size") Integer size);

	public int getAuthorCount(@Param("author") String author);

	public List<Book> findPageBookByDesc(@Param("desc") String desc, @Param("current") Integer current,
			@Param("size") Integer size);

	public int getDescCount(@Param("desc") String desc);

	public List<Book> findPageBookByCName(@Param("cname") String cname, @Param("current") Integer current,
			@Param("size") Integer size);

	public int getCNameCount(@Param("cname") String cname);

	public List<Book> findPageBookByCDesc(@Param("cdesc") String cdesc, @Param("current") Integer current,
			@Param("size") Integer size);

	public int getCDescCount(@Param("cdesc") String cdesc);

	public List<Book> findPageBookByAll(@Param("all") String all, @Param("current") Integer current,
			@Param("size") Integer size);

	public int getAllCount(@Param("all") String all);

	public int getPressCount(@Param("press")String press);

	public List<Book> findPageBookByPress(@Param("press")String press, @Param("current") Integer current,
			@Param("size") Integer size);
}
