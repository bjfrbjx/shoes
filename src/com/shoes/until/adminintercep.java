package com.shoes.until;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class adminintercep extends AbstractInterceptor {

	public adminintercep() {
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("�жϹ���Ա");
		HttpSession session=ServletActionContext.getRequest().getSession();
		Boolean isadmin =(Boolean)session.getAttribute("admin");
		if( isadmin==null || isadmin!=true)
			return "error";
		else
			return invocation.invoke();
	}

}
