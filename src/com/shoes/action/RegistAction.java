package com.shoes.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shoes.until.Service;

import cn.Users;

public class RegistAction extends ActionSupport {
	private Users user=new Users();
	String token=null;
	public void setToken(String token) { this.token = token; }
	public String getToken() { return token; }
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public RegistAction() {
		// TODO 自动生成的构造函数存根
	}
	public String regist() throws SQLException {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("admin",new Boolean(false));
		Boolean r=Service.regist(this.user);
		if(!r){
			 request.setAttribute("error", "注册失败");
		 return ERROR;
		 }
		 else {
			 request.getSession().setAttribute("user", this.user);
			 return SUCCESS;
		 }
	}

}
