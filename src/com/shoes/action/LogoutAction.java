package com.shoes.action;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class LogoutAction extends ActionSupport {

	public LogoutAction() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	
	public String logout() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().invalidate();
		return SUCCESS;
	}
	}
