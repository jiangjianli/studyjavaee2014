package com.jiang.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.jiang.pojo.Customer;
import com.jiang.service.CustomerService;
import com.jiang.service.impl.CustomersImpl;

public class LoginAndRegisterServlet extends HttpServlet {

	
	private CustomerService customerservice = new CustomersImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String op = req.getParameter("op");
		
		if (op.equals("regiser")) {
			Customer customer = new Customer();
			try {
				BeanUtils.populate(customer, req.getParameterMap());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Customer customer2 = this.customerservice.findCustomByUserName(customer.getUsername());
			if (customer2 == null) {
				this.customerservice.addCustomer(customer);
				resp.sendRedirect("login.jsp");
			}else {
				
			}
			
		}else if (op.equals("login")) {
			
			String username = req.getParameter("username");
			
		    Customer customer	= this.customerservice.findCustomByUserName(username);
			
			if (customer == null) {
				
			}else {
				
				String password = req.getParameter("password");
				if (customer.getPassword().equals(password)) {
					HttpSession session = req.getSession();
					session.setAttribute("customer", customer);
					resp.sendRedirect("web?op=gohome");
				}else
				{
					
				}
				
			}
		}else if (op.equals("logout")) {
			HttpSession session = req.getSession();
			session.removeAttribute("customer");
			resp.sendRedirect("web?op=gohome");
		}
			
		
		
		
	}

	
	
	
	
}
