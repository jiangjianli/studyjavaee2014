package com.jiang.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.jiang.dao.BookDao;
import com.jiang.pojo.Book;
import com.jiang.pojo.Category;
import com.jiang.util.DBCPUtil;
import com.jiang.util.Page;

public class BookDaoImpl implements BookDao {

	QueryRunner queryRunner = new QueryRunner(DBCPUtil.getdatasource());

	public void saveBook(Book moden) {
		// TODO Auto-generated method stub

		try {
			queryRunner.update("insert into book(id,name,author,path,filename,price,categoryId,description) "
													+ "	values (?,?,?,?,?,?,?,?)",
													moden.getId(),moden.getName(),moden.getAuthor(),moden.getPath(),
													moden.getFilename(),moden.getPrice(),moden.getCategory().getId(),
													moden.getDescription());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Book findBookById(String id) {
		// TODO Auto-generated method stub
		
		try {
			
			Book book	= queryRunner.query("select * from book where id = ?", new BeanHandler<Book>(Book.class),id);
			
			if (book != null) {
				Category category	= queryRunner.query("select * from category where id = (select categoryId from book where id = ?)", new BeanHandler<Category>(Category.class),id);
				book.setCategory(category);
				
			}
			return book;
			// (select id from category where id = ?
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	
	public List<Book> findBookPageRecords(int startindex,int pagesize) {
		// TODO Auto-generated method stub
		try {
			
			List<Book> books	= queryRunner.query("select * from book limit ?,?", new BeanListHandler<Book>(Book.class),startindex,pagesize);
			
			if (books != null && books.size() > 0) {
				for (Book book2 : books) {
					Category category	= queryRunner.query("select * from category where id = (select categoryId from book where id = ?)", new BeanHandler<Category>(Category.class),book2.getId());
					book2.setCategory(category);
				}
				
				
			}
			return books;
			// (select id from category where id = ?
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	public int countBookTotal() {
		// TODO Auto-generated method stub
		

		try {
			
			Object object	= queryRunner.query("select count(*) from book ", new ScalarHandler(1));
			Long count = (Long)object;
			
			
			return count.intValue();
			// (select id from category where id = ?
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}

	public List<Book> findBookPageRecords(int startindex, int pagesize, String categoryId) {
		// TODO Auto-generated method stub
		
		try {
			
			List<Book> books	= queryRunner.query("select * from book where categoryId = ? limit ?,?", new BeanListHandler<Book>(Book.class),categoryId,startindex,pagesize);
			
			if (books != null && books.size() > 0) {
				Category category	= queryRunner.query("select * from category where id = ?", new BeanHandler<Category>(Category.class),categoryId);
				for (Book book2 : books) {
					
					book2.setCategory(category);
				}
				
				
			}
			return books;
			// (select id from category where id = ?
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	public int countBookTotal(String categoryId) {
		// TODO Auto-generated method stub
		
		

		try {
			
			Object object	= queryRunner.query("select count(*) from book where categoryId = ?", new ScalarHandler(1),categoryId);
			Long count = (Long)object;
			
			
			return count.intValue();
			// (select id from category where id = ?
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}



}
