package com.lxhf.bean;

import java.util.List;

public class Page {
	private Integer totalPage;
	private List<Book> books;
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Page [totalPage=" + totalPage + ", books=" + books + "]";
	}
	public Page(Integer totalPage, List<Book> books) {
		super();
		this.totalPage = totalPage;
		this.books = books;
	}
	public Page() {
		super();
	}
	
	
}
