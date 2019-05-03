package com.shoes.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shoes.entity.Users;
import com.shoes.until.Service;

public class LoginAction extends ActionSupport {
	private Service service=null; 
	private Users user=new Users();
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}

	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
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
		Boolean dl=service.login(this.user);
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
	}
}
