package com.jiang.service;

import com.jiang.pojo.Customer;

public interface CustomerService {

	
	void addCustomer(Customer moden);
	
	Customer findCustomByid(String id);
	
	
	Customer findCustomByUserName(String username);
	
}
