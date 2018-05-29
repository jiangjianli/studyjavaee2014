package com.jiang.pojo;

import java.io.Serializable;


///sql

// 
/*create database bookstory;
use bookstory;
create table category(

	id varchar(255) primary key,
	name varchar(255),
	description varchar(255)

);


*/
public class Category implements Serializable{

	private String id;
	
	private String name;
	
	
	private String description;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
