package com.jiang.test;

import java.security.Provider.Service;

import org.junit.Test;

import com.jiang.pojo.Category;
import com.jiang.service.CategoryService;
import com.jiang.service.impl.CategoryImpl;


public class CategoryTest {

	
	
	CategoryService Service =  new CategoryImpl();
	
	@Test
	public void test1() {
		Category category = new Category();
		category.setName("�����2");
		category.setDescription("���������鼮1");
		Service.addCategory(category);
		
	}
	
}
