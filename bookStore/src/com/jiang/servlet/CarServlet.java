package com.jiang.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jiang.car.Car;
import com.jiang.pojo.Book;
import com.jiang.service.BookService;
import com.jiang.service.impl.BookServiceImpl;

public class CarServlet extends HttpServlet {

	
	private BookService Service =  new BookServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String op = req.getParameter("op");
		
		if (op.equals("addcar")) {
			String id = req.getParameter("id");
			Book book =  Service.findBookById(id);
			
			HttpSession session = req.getSession();
			Car car =  (Car) session.getAttribute("car");
			if (car == null) {
				car = new Car();
				
				
			}
			car.addBook(book);
			session.setAttribute("car", car);
		}else if (op.equals("showcar")) {
//			HttpSession session = req.getSession();
//			Car car =  (Car) session.getAttribute("car");
			
			
		}else if (op.equals("deletecar")) {
			String id = req.getParameter("id");
			HttpSession session = req.getSession();
			Car car =  (Car) session.getAttribute("car");
			car.removeBookByid(id);
			session.setAttribute("car", car);
			resp.sendRedirect("showcar.jsp");
		}
		
	}

	
	
	
	
}
