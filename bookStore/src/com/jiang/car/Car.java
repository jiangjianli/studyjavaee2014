package com.jiang.car;

import java.util.HashMap;
import java.util.Map;

import com.jiang.pojo.Book;

public class Car {
	
	public Map<String, CarItem> map = new HashMap<String, CarItem>();
	

	private int quanity;
	
	private float price;

	
	public void removeBookByid(String bookId) {
		this.map.remove(bookId);
	}
	
	public void addBook(Book book) {
		if (map.containsKey(book.getId())) {
			CarItem carItem = map.get(book.getId());
			carItem.setQuanity(carItem.getQuanity() + 1);
			
		}else {
			CarItem item = new CarItem(book);
			item.setQuanity(1);
			map.put(book.getId(), item);
		}
	}
	
	
	public Map<String, CarItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CarItem> map) {
		this.map = map;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	
	
	
	
}
