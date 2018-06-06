package com.jiang.car;

import com.jiang.pojo.Book;

public class CarItem {

	
	private Book book;
	
	private int quanity;
	
	private  float price;
	
	public CarItem(Book book ) {
		// TODO Auto-generated constructor stub
		this.book = book;
		
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public float getPrice() {
		return this.quanity * this.book.getPrice();
		 
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
}
