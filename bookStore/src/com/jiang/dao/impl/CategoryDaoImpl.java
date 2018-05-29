package com.jiang.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.jiang.dao.CategoryDao;
import com.jiang.pojo.Category;
import com.jiang.util.DBCPUtil;

public class CategoryDaoImpl implements CategoryDao{

	QueryRunner queryRunner = new QueryRunner(DBCPUtil.getdatasource());
	
	
	
	public void addCategory(Category moden) {
		// TODO Auto-generated method stub
		try {
			queryRunner.update("insert into category(id,name,description) values (?,?,?)",moden.getId(),moden.getName(),moden.getDescription());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		try {
			List<Category> list =  queryRunner.query("select * from category", new BeanListHandler<Category>(Category.class));
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public Category findCategoryById(String id) {
		// TODO Auto-generated method stub
		
		try {
			Category category = queryRunner.query("select * from category where id = ?", new BeanHandler<Category>(Category.class),id);
			
			return category;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
