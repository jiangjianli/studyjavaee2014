package com.jiang.service;

import com.jiang.pojo.Book;
import com.jiang.util.Page;

public interface BookService {

	
	void saveBook(Book book);
	
	
	Book findBookById(String id);
	
	
	Page findBookPageRecords(String num);
	
	Page findBookByCategoryPageRecords(String num,String categoryId);
	
}
