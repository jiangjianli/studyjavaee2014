package com.jiang.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.jiang.dao.CustomerDao;
import com.jiang.pojo.Category;
import com.jiang.pojo.Customer;
import com.jiang.util.DBCPUtil;

public class CustomersDaoImpl implements CustomerDao {

	QueryRunner queryRunner = new QueryRunner(DBCPUtil.getdatasource());
	

	public void addCustom(Customer moden) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		try {
				queryRunner.update("insert into customer(id,username,password,address,email,nickname) "
						+ "values (?,?,?,?,?,?)",moden.getId(),moden.getUsername(),moden.getPassword(),moden.getAddress(),moden.getEmail(),moden.getNickName());
			} catch (SQLException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public Customer findCustomByid(String id) {
		// TODO Auto-generated method stub
		
		try {
			Customer category = queryRunner.query("select * from customer where id = ?", new BeanHandler<Customer>(Customer.class),id);
			
			return category;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public Customer findCustomByUserName(String username) {
		// TODO Auto-generated method stub
		try {
			Customer category = queryRunner.query("select * from customer where username = ?", new BeanHandler<Customer>(Customer.class),username);
			
			return category;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
