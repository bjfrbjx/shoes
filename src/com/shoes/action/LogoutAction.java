package com.shoes.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shoes.entity.User;
import com.shoes.until.DB;


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
