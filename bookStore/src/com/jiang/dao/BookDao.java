package com.jiang.dao;


import java.util.List;

import com.jiang.pojo.Book;
import com.jiang.util.Page;

public interface BookDao {

	
	void saveBook(Book book);
	
	
	Book findBookById(String id);
	
	
	List<Book> findBookPageRecords(int startindex,int pagesize);
	
	int countBookTotal();
	
	List<Book> findBookPageRecords(int startindex,int pagesize,String categoryId);


	int countBookTotal(String categoryId);
	
}
