package com.shoes.action;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class LogoutAction extends ActionSupport {

	public LogoutAction() {
		// TODO 自动生成的构造函数存根
	}
	
	
	public String logout() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().invalidate();
		return SUCCESS;
	}
	}
