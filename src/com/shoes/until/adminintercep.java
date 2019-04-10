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
		System.out.println("判断管理员");
		HttpSession session=ServletActionContext.getRequest().getSession();
		Boolean isadmin =(Boolean)session.getAttribute("admin");
		if( isadmin==null || isadmin!=true)
			return "error";
		else
			return invocation.invoke();
	}

}
