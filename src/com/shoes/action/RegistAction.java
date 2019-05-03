package com.shoes.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shoes.entity.Users;
import com.shoes.until.Service;
import com.opensymphony.xwork2.validator.validators.ExpressionValidator;
public class RegistAction extends ActionSupport {
	private Service service=null; 
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
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
		Boolean r=service.regist(this.user);
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
