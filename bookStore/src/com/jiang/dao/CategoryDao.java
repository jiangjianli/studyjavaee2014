package com.jiang.dao;

import java.util.List;

import com.jiang.pojo.Category;

public interface CategoryDao {

	
	void addCategory(Category moden);
	
	List<Category> findAllCategory();
	
	Category findCategoryById(String id);
	
	
}
