package com.shoes.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shoes.entity.User;
import com.shoes.until.DB;

public class RegistAction extends ActionSupport {
	private User user=new User();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public RegistAction() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public String regist() throws SQLException {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("admin",new Boolean(false));
		;
		Boolean r=DB.regist(this.user.getName(), this.user.getSex(), this.user.getPassword(),this.user.getEmail());
		if(!r){
			 request.setAttribute("error", "ע��ʧ��");
		 return ERROR;
		 }
		 else {
			 request.getSession().setAttribute("user", this.user);
			 return SUCCESS;
		 }
	}

}
