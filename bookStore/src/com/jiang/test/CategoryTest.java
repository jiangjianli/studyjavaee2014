package com.jiang.test;

import java.security.Provider.Service;

import org.junit.Test;

import com.jiang.dao.impl.CustomersDaoImpl;
import com.jiang.pojo.Category;
import com.jiang.pojo.Customer;
import com.jiang.service.CategoryService;
import com.jiang.service.CustomerService;
import com.jiang.service.impl.CategoryImpl;
import com.jiang.service.impl.CustomersImpl;


public class CategoryTest {

	CustomerService customerService = new CustomersImpl();
	
	
	
	@Test
	public void test2() {
		Customer moden = new Customer();
		moden.setNickName("jiangjian");
		moden.setPassword("123456");
		moden.setUsername("jiang");
		moden.setEmail("5138");
		
		this.customerService.addCustomer(moden);
	}
	
	
	
	
	CategoryService Service =  new CategoryImpl();
	
	
	
	@Test
	public void test1() {
		Category category = new Category();
		category.setName("计算机2");
		category.setDescription("计算机类的书籍1");
		Service.addCategory(category);
		
	}
	
}
