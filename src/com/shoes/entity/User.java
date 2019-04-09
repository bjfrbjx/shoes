package com.shoes.entity;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.shoes.until.DB;

public class User implements HttpSessionBindingListener {
private String name=null;
private String email=null;
private String sex=null;
String password=null;
public User(String name, String email, String sex, String password) {
	super();
	this.name = name;
	this.email = email;
	this.sex = sex;
	this.password = password;
}
	public User() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		;
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		//arg0.getSession().setMaxInactiveInterval(60*30*20);
		try {
			arg0.getSession().setAttribute("order", DB.getorder(this));
			arg0.getSession().setAttribute("preorder", DB.getpreorder(this));
			System.out.println( DB.getpreorder(this).size());
			arg0.getSession().setAttribute("Shoeslist", DB.getshoes());
		Integer Lognum=(Integer)arg0.getSession().getServletContext().getAttribute("LoginNum");
		arg0.getSession().getServletContext().setAttribute("LoginNum",++Lognum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		//arg0.getSession().setMaxInactiveInterval(60);
		Integer Lognum=(Integer)arg0.getSession().getServletContext().getAttribute("LoginNum");
		arg0.getSession().getServletContext().setAttribute("LoginNum",--Lognum);
	}
	@Override
	public String toString() {
		return "User  name=" + name + ", email=" + email + ", sex=" + sex + ", password=" + password + "]";
	}
	public List<Order> getorder() throws SQLException{
		return DB.getorder(this);
	}
	public Set<Preorder> getpreorder() throws SQLException{
		return DB.getpreorder(this);
	}
}
