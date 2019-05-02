package com.shoes.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.Orders;
import cn.Preorder;
import cn.Users;
 
import com.shoes.until.Service;

public class CheckAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -493214965117151809L;
	private Preorder preord=new Preorder();
	private Orders order=new Orders();
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Preorder getPreord() {
		return preord;
	}
	public void setPreord(Preorder preord) {
		this.preord = preord;
	}
	public CheckAction() {
		// TODO 自动生成的构造函数存根
	}
	public String createpreorder() throws UnsupportedEncodingException, SQLException {
		HttpServletRequest request=ServletActionContext.getRequest();
		String username= ((Users)request.getSession().getAttribute("user")).getName();	
		this.preord.setUserid(username);
		if(preord.getPreorderid()==null) {
		String orderID=username+"-"+Integer.toHexString((int) (Math.random()*1000))+"-"+this.preord.getShoeid();
		this.preord.setPreorderid(orderID);
		}
		else {
			this.rempreord();
		}
		request.getSession().setAttribute("payorder",preord);
		return SUCCESS;
	}
	public String createorder() {
		HttpServletRequest request=ServletActionContext.getRequest();
			Service.addOder(this.order);
			request.setAttribute("order", this.order);
			return SUCCESS;
		
	}
	public String shopping() throws UnsupportedEncodingException, SQLException {
		HttpServletRequest request=ServletActionContext.getRequest();
		this.createpreorder();
		Service.addpreorder(preord);
		List<Preorder> pds=(List<Preorder>)request.getSession().getAttribute("preorder");
		pds.add(preord);
		return SUCCESS;
	}
	public String getorders() throws SQLException {
		HttpSession session=ServletActionContext.getRequest().getSession();
		List<Orders> orders=Service.getorder((Users)session.getAttribute("user"));
		ActionContext.getContext().put("orders", orders);
		return SUCCESS;
	}
	public String cleanpreord() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Users u=(Users)request.getSession().getAttribute("user");
		if(u!=null&&!u.getName().equals("")) {
			Service.cleanpreord(u);
			((List<Preorder>)request.getSession().getAttribute("preorder")).clear();
			}
		return SUCCESS;
		
	}
	public String rempreord() throws  SQLException {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		if(this.preord.getPreorderid()!=null) {
			List<Preorder> pl=(List<Preorder>)request.getSession().getAttribute("preorder");
			System.out.println(pl.size());
			pl.remove(this.preord);
			System.out.println(pl.size());
			Service.removepreord(this.preord);
			return SUCCESS;
		}
		return ERROR;
	}
	}

