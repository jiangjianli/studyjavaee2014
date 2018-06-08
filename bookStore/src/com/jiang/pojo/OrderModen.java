package com.jiang.pojo;

import java.io.Serializable;
import java.util.List;

public class OrderModen implements Serializable {

	private String ordersnum;
	
	private int totalnum;
	
	private float totalprice;
	
	private int status;
	
	private String customerId;
	
	private List<OrderCarItem>list;

	public String getOrdersnum() {
		return ordersnum;
	}

	public void setOrdersnum(String ordersnum) {
		this.ordersnum = ordersnum;
	}

	public int getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<OrderCarItem> getList() {
		return list;
	}

	public void setList(List<OrderCarItem> list) {
		this.list = list;
	}
	
	
	
}
