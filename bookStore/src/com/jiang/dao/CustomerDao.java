package com.jiang.dao;

import com.jiang.pojo.Customer;

public interface CustomerDao {

	void addCustom(Customer moden);

	Customer findCustomByid(String id);

	Customer findCustomByUserName(String username);

}
