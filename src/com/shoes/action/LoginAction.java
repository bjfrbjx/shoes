package com.shoes.action;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.opensymphony.xwork2.ActionSupport;
import com.shoes.entity.Comments;
import com.shoes.entity.Users;
import com.shoes.until.AlipayConfig;
import com.shoes.until.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LoginAction extends ActionSupport {
	private Service service=null; 
	private Users user=new Users();
	private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
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
		// TODO 自动生成的构造函数存根
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
			request.setAttribute("error","登陆失败");
			request.getSession().setAttribute("admin",new Boolean(false));
		return ERROR;
		}
		else {
			request.getSession().setAttribute("admin",new Boolean(false));
			request.getSession().setAttribute("user", this.user);
			return SUCCESS;
		}
	}
	public String getuserinfo() throws SQLException, IOException {
		//HttpServletResponse resp=ServletActionContext.getResponse();
		System.out.println(this.user);
		if(!this.user.getName().equals("")) {
			this.user=service.getone(this.user);
			//JSONArray jsonArray = JSONArray.fromObject(cl);
			result =JSONObject.fromObject(this.user).toString();
			System.out.println(result);
			//result = jsonobj.toString();
			//resp.setContentType("text/html;charset=utf-8");   
	        // resp.setHeader("Access-Control-Allow-Origin", "*");  
	        //resp.setHeader("Access-Control-Allow-Methods", "GET,POST");  
	        //Writer out = resp.getWriter(); 
	        //out.write(result);
	        //out.close();
			return SUCCESS;
		}
		return ERROR;
	}

}
