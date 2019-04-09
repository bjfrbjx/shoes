package com.shoes.entity;

public class Shoes {
	String brand=null;
	float size=0.0f;
	String kind=null;
	String sex=null;
	String shoeID=null;
	String IMG=null;
	float price=0.0f;
	public Shoes(String brand, float size, String kind, String sex, String shoeID,String Img,float price) {
		super();
		this.brand = brand;
		this.size = size;
		this.kind = kind;
		this.sex = sex;
		this.shoeID = shoeID;
		this.IMG=Img;
		this.price=price;
	}

	public Shoes() {}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getShoeID() {
		;
		return shoeID;
	}
	public void setShoeID(String shoeID) {
		;
		this.shoeID = shoeID;
	}
	public String getIMG() {
		return IMG;
	}
	public void setIMG(String iMG) {
		IMG = iMG;
	}

}
