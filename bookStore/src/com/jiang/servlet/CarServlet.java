package com.jiang.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jiang.car.Car;
import com.jiang.car.CarItem;
import com.jiang.pojo.Book;
import com.jiang.pojo.Customer;
import com.jiang.pojo.OrderCarItem;
import com.jiang.pojo.OrderModen;
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
		}else if (op.equals("create")) {
			OrderModen mmModen = new OrderModen();
			HttpSession session = req.getSession();
			Car car =  (Car) session.getAttribute("car");
			
			Customer customer =  (Customer) session.getAttribute("customer");
			
			if (customer == null) {
				resp.sendRedirect("login.jsp");
				return;
			}
			
			Date date = new Date();
			DateFormat dFormat = new SimpleDateFormat("yyyy:mm:dd hh:mm:ss");
			
			String string = dFormat.format(date);
			mmModen.setOrdersnum(string);
			mmModen.setTotalnum(car.getQuanity());
			mmModen.setTotalprice(car.getPrice());
			
			List<OrderCarItem> list = new ArrayList<OrderCarItem>();
			
			for (CarItem item : car.map.values()) {
				OrderCarItem iCarItem = new OrderCarItem();
				iCarItem.setId(UUID.randomUUID().toString());
				iCarItem.setNum(item.getQuanity());
				iCarItem.setPrice(car.getPrice());
				iCarItem.setBook(item.getBook());
				list.add(iCarItem);
			}
			mmModen.setList(list);
			mmModen.setCustomerId(customer.getId());
			this.Service.saveOrder(mmModen);
		}
		
	}

	
	
	
	
}
