package com.jiang.service.impl;

import java.util.UUID;

import com.jiang.dao.CustomerDao;
import com.jiang.dao.impl.CustomersDaoImpl;
import com.jiang.pojo.Customer;
import com.jiang.service.CustomerService;

public class CustomersImpl implements CustomerService{

	private CustomerDao dao = new CustomersDaoImpl();
	
	public void addCustomer(Customer moden) {
		// TODO Auto-generated method stub
		moden.setId(UUID.randomUUID().toString());
		this.dao.addCustom(moden);
	}

	public Customer findCustomByid(String id) {
		// TODO Auto-generated method stub
		
		Customer customer = this.dao.findCustomByid(id);
		return customer;
	}

	public Customer findCustomByUserName(String username) {
		// TODO Auto-generated method stub
		Customer customer = this.dao.findCustomByUserName(username);
		return customer;
		//return null;
	}

}
