package com.lxhf.bean;

public class Book {

	private Integer id;               // 主键
	private String name;              // 图名
	private String description;       // 图书描述
	private String author;            // 作者
	private float price;              // 定价
	private float currprice;          // 当前价
	private float discount;           // 折扣
	private String press;             // 出版社
	private String publishtime;       // 出版时间
	private int edition;              // 版次
	private int pagenum;			  // 页数
	private int wordnum;			  // 字数
	private String printtime;         // 刷新时间
	private int booksize;             // 开本
	private String paper;             // 纸质
	private String image_w;           // 大图路径
	private String image_b;           // 小图路径
	private Category category;        // 所属分类
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getCurrprice() {
		return currprice;
	}
	public void setCurrprice(float currprice) {
		this.currprice = currprice;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getWordnum() {
		return wordnum;
	}
	public void setWordnum(int wordnum) {
		this.wordnum = wordnum;
	}
	public String getPrinttime() {
		return printtime;
	}
	public void setPrinttime(String printtime) {
		this.printtime = printtime;
	}
	public int getBooksize() {
		return booksize;
	}
	public void setBooksize(int booksize) {
		this.booksize = booksize;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public String getImage_w() {
		return image_w;
	}
	public void setImage_w(String image_w) {
		this.image_w = image_w;
	}
	public String getImage_b() {
		return image_b;
	}
	public void setImage_b(String image_b) {
		this.image_b = image_b;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description=" + description + ", author=" + author + ", price="
				+ price + ", currprice=" + currprice + ", discount=" + discount + ", press=" + press + ", publishtime="
				+ publishtime + ", edition=" + edition + ", pagenum=" + pagenum + ", wordnum=" + wordnum
				+ ", printtime=" + printtime + ", booksize=" + booksize + ", paper=" + paper + ", image_w=" + image_w
				+ ", image_b=" + image_b + ", category=" + category + "]";
	}
	
}
