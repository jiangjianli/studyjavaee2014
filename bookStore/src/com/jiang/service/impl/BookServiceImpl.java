package com.jiang.service.impl;

import java.util.List;
import java.util.UUID;

import com.jiang.dao.BookDao;
import com.jiang.dao.impl.BookDaoImpl;
import com.jiang.pojo.Book;
import com.jiang.service.BookService;
import com.jiang.util.Page;

public class BookServiceImpl implements BookService{

	
	BookDao dao = new BookDaoImpl();
	
	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		book.setId(UUID.randomUUID().toString());
		dao.saveBook(book);
	}

	public Book findBookById(String id) {
		// TODO Auto-generated method stub
		Book book = dao.findBookById(id);
		return book;
	}

	public Page findBookPageRecords(String num) {
		// TODO Auto-generated method stub
		
		int numpage = 1;
		if (num != null && !num.equals("") ) {
			numpage = Integer.parseInt(num);
		}
		
		int total= dao.countBookTotal();	
		Page page = new Page(numpage, total);
		//page.setPageSize(3);
		List<Book> books = dao.findBookPageRecords(page.getStartIndex() , page.getPageSize());
		page.setRecoder(books);
		System.out.println("totalPage == " + page.getTotalPage());
		return page;
	}

	public Page findBookByCategoryPageRecords(String num, String categoryId) {
		// TODO Auto-generated method stub
		
		int numpage = 1;
		if (num != null && !num.equals("") ) {
			numpage = Integer.parseInt(num);
		}
		
		int total= dao.countBookTotal(categoryId);	
		Page page = new Page(numpage, total);
		//page.setPageSize(3);
		List<Book> books = dao.findBookPageRecords(page.getStartIndex(), page.getPageSize(), categoryId);
		page.setRecoder(books);
		
		return page;
		
	
	}

}
