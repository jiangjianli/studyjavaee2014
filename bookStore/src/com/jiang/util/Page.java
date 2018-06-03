package com.jiang.util;

import java.util.List;

public class Page {

	int currentPage;
	
	int prePage;
	
	int nextPage;
	
	int totalPage;
	
	int pageSize = 3;
	
	int startIndex;
	
	int totalRecoder;
	
	List recoder;

	
	public Page(int current,int totalRecoder) {
		// TODO Auto-generated constructor stub
		this.currentPage = current;
		this.totalRecoder = totalRecoder;
		int pp	= this.totalRecoder%this.pageSize == 0?this.totalRecoder/this.pageSize:(this.totalRecoder/this.pageSize) + 1;
		this.totalPage = pp;
		
	}
	
	public int getTotalPage() {
		
	int pp	= this.totalRecoder%this.pageSize == 0?this.totalRecoder/this.pageSize:(this.totalRecoder/this.pageSize) + 1;
		return pp;
	//	return totalPage;
	}

	public void setTotalPage(int totalPage) {

		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPrePage() {
		if (currentPage - 1 > 0) {
			return currentPage - 1;
		}
		return 1;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		if (this.currentPage + 1 <= this.totalPage) {
			return  this.currentPage + 1;
		}
		return this.currentPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		
		
		
		return pageSize * (currentPage - 1);
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalRecoder() {
		return totalRecoder;
	}

	public void setTotalRecoder(int totalRecoder) {
		this.totalRecoder = totalRecoder;
	}

	public List getRecoder() {
		return recoder;
	}

	public void setRecoder(List recoder) {
		this.recoder = recoder;
	}
	
	
	
	
}
