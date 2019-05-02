package com.shoes.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import cn.Users;
 
import com.shoes.until.Service;

public class LoginAction extends ActionSupport {
	private Users user=new Users();
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public LoginAction() {
		// TODO 自动生成的构造函数存根
	}
	public String login() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String password=this.user.getPassword();
		String name=this.user.getName();
		if(name.equals("admin")&&password.equals("admin")) {
			request.getSession().setAttribute("user", this.user);
			request.getSession().setAttribute("admin",new Boolean(true));
			return "admin";
		}
		Boolean dl=Service.login(this.user);
		if(!dl) {
			request.getSession().removeAttribute("user");
			request.setAttribute("error","登陆失败");
			request.getSession().setAttribute("admin",new Boolean(false));
		return ERROR;
		}
		else {
			request.getSession().setAttribute("admin",new Boolean(false));
			request.getSession().setAttribute("user", this.user);
			return SUCCESS;
		}
	}
}
