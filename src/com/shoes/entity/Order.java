package com.shoes.entity;

public class Order {
	private String orderID=null;
	private String username=null;
	private String shoeID=null;
	private int num=0;
	private String date=null;
	private float sumpric=0.0f;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		return true;
	}
	public float getSumpric() {
		return sumpric;
	}
	public void setSumpric(float sumpric) {
		this.sumpric = sumpric;
	}
	public Order() {
		// TODO 自动生成的构造函数存根
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getShoeID() {
		return shoeID;
	}
	public void setShoeID(String shoeID) {
		this.shoeID = shoeID;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Order(String orderID, String username, String shoeID, int num, String date,float singlepric) {
		super();
		this.orderID = orderID;
		this.username = username;
		this.shoeID = shoeID;
		this.num = num;
		this.date = date;
		this.sumpric=num*singlepric;
	}
	@Override
	public String toString() {
		return "Order :" + orderID + "/username=" + username + "/shoeID=" + shoeID + "/num=" + num
				+ "/date=" + date + "/sumpric=" + sumpric;
	}

}
