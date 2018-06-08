package com.jiang.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.jiang.dao.CarDao;
import com.jiang.pojo.Book;
import com.jiang.pojo.OrderCarItem;
import com.jiang.pojo.OrderModen;
import com.jiang.util.DBCPUtil;

public class CarDaoImpl implements CarDao {

	QueryRunner queryRunner = new QueryRunner(DBCPUtil.getdatasource());

	
	public void createOrder(OrderModen moden) {
		// TODO Auto-generated method stub

		try {
			queryRunner.update("insert into orders(ordersnum,totalnum,totalprice,status,customerId) "
													+ "	values (?,?,?,?,?)",
													moden.getOrdersnum(),moden.getTotalnum(),moden.getTotalprice(),moden.getStatus(),
													moden.getCustomerId());
		
		
			for (OrderCarItem carItem : moden.getList()) {
				
				queryRunner.update("insert into ordersitem(id,num,price,bookId,ordersId) "
						+ "	values (?,?,?,?,?)",
						carItem.getId(),carItem.getNum(),carItem.getPrice(),carItem.getBook().getId(),
						moden.getOrdersnum());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
