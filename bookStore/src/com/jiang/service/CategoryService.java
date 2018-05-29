package com.jiang.service;



import java.util.List;

import com.jiang.pojo.Category;

public interface CategoryService {

	void addCategory(Category moden);
	
	List<Category> findAllCategory();
	
	Category findCategoryById(String id);
	
	
	
	
}
