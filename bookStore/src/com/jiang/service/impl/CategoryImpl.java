package com.jiang.service.impl;

import java.util.List;
import java.util.UUID;

import com.jiang.dao.CategoryDao;
import com.jiang.dao.impl.CategoryDaoImpl;
import com.jiang.pojo.Category;
import com.jiang.service.CategoryService;

public class CategoryImpl implements CategoryService{

	private CategoryDao dao = new CategoryDaoImpl();
	
	public void addCategory(Category moden) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		moden.setId(uuid);
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
