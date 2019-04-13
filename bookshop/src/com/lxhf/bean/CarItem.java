package com.lxhf.bean;

public class CarItem {
	private Integer id;
	private Integer bookid;
	private int num;
	private float money;
	private Integer customerid;
	private Book book;

	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "CarItem [id=" + id + ", bookid=" + bookid + ", num=" + num + ", money=" + money + ", customerid="
				+ customerid + ", book=" + book + "]";
	}

	
}
