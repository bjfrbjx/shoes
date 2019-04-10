package com.shoes.until;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class userintercep extends AbstractInterceptor {

	public userintercep() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("判断登陆");
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(session.getAttribute("user")==null)
			return "error";
		else
			return invocation.invoke();
	}

}
