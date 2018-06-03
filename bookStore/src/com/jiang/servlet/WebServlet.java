package com.jiang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.jiang.pojo.Book;
import com.jiang.pojo.Category;
import com.jiang.service.BookService;
import com.jiang.service.CategoryService;
import com.jiang.service.impl.BookServiceImpl;
import com.jiang.service.impl.CategoryImpl;
import com.jiang.util.Page;

public class WebServlet extends HttpServlet {

	private CategoryService categoryservice = new CategoryImpl();
	
	private BookService bookservice = new BookServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String op = req.getParameter("op");
		
		if (op.equals("gohome")) {
			
			List<Category> categorys = categoryservice.findAllCategory();
			req.setAttribute("category", categorys);
			int pagei = 1;
			String numstr = req.getParameter("num");
			if (numstr != null ) {
				pagei =  Integer.parseInt(numstr);
			}
		  Page page = bookservice.findBookPageRecords(pagei + "");
		  req.setAttribute("page", page);
		  getServletContext().setAttribute("selectcategoryid", "");
		  req.setAttribute("selectcategoryid", "");
		  req.getRequestDispatcher("/home.jsp").forward(req, resp);
		  
		}else if (op.equals("gohomeandcategory")) {
		
			    String categoryId = req.getParameter("categoryId");
			 
			    
				List<Category> categorys = categoryservice.findAllCategory();
				req.setAttribute("category", categorys);
				int pagei = 1;
				String numstr = req.getParameter("num");
				if (numstr != null ) {
					pagei =  Integer.parseInt(numstr);
				}
			  //String categoryId = req.getParameter("categoryId");
			  Page page = bookservice.findBookByCategoryPageRecords(pagei+"", categoryId);
			  req.setAttribute("page", page);
			  getServletContext().setAttribute("selectcategoryid", categoryId);
			  //req.setAttribute("selectcategoryid", categoryId);
			  req.getRequestDispatcher("/home.jsp").forward(req, resp);
			  
			}
			
			
		}
		
		
	

	
	
	
	
}
