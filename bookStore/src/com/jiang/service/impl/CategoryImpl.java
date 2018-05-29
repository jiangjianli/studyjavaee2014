package com.jiang.service.impl;

import java.util.List;

import com.jiang.dao.CategoryDao;
import com.jiang.dao.impl.CategoryDaoImpl;
import com.jiang.pojo.Category;
import com.jiang.service.CategoryService;

public class CategoryImpl implements CategoryService{

	private CategoryDao dao = new CategoryDaoImpl();
	
	public void addCategory(Category moden) {
		// TODO Auto-generated method stub
		dao.addCategory(moden);
	}

	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		
		return dao.findAllCategory();
	}

	public Category findCategoryById(String id) {
		// TODO Auto-generated method stub
		return dao.findCategoryById(id);
	}



}
