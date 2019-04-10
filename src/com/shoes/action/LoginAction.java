package com.shoes.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shoes.entity.User;
import com.shoes.until.DB;

public class LoginAction extends ActionSupport {
	private User user=new User();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LoginAction() {
		// TODO �Զ����ɵĹ��캯�����
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
		try {
			Boolean dl=DB.login(this.user.getName(), this.user.getPassword());
			if(!dl) {
				request.getSession().removeAttribute("user");
				request.setAttribute("error","��½ʧ��");
				request.getSession().setAttribute("admin",new Boolean(false));
			return ERROR;
			}
			else {
				request.getSession().setAttribute("admin",new Boolean(false));
				request.getSession().setAttribute("user", this.user);
				return SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ERROR;
	}
}
