package com.shoes.entity;

import java.util.Date;

public class Comment {
	private String shoeid=null;
	private String username=null;
	private String message=null;
	public String getShoeid() {
		return shoeid;
	}
	public void setShoeid(String shoeid) {
		this.shoeid = shoeid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private String date=(new Date()).toLocaleString();
	public Comment() {
		// TODO 自动生成的构造函数存根
	}

}
