package com.shoes.entity;


public class Preorder {
@Override
	public String toString() {
		return "Preorder [orderID=" + orderID + ", username=" + username + ", shoeID=" + shoeID + "]";
	}
private String orderID=null;
public Preorder(String orderID, String username, String shoeID) {
	super();
	this.orderID = orderID;
	this.username = username;
	this.shoeID = shoeID;
}
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
	Preorder other = (Preorder) obj;
	if (orderID == null) {
		if (other.orderID != null)
			return false;
	} else if (!orderID.equals(other.orderID))
		return false;
	return true;
}
private String username=null;
private String shoeID=null;
	public Preorder() {
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
		;
		return shoeID;
	}
	public void setShoeID(String shoeID) {
		this.shoeID = shoeID;
	}

}
