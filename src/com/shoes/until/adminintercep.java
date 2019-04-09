package com.shoes.until;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class adminintercep extends AbstractInterceptor {

	public adminintercep() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		if((Boolean)session.getAttribute("admin")!=true )
			return null;
		else
			return invocation.invoke();
	}

}
