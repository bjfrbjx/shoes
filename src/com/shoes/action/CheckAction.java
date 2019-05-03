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
import com.shoes.entity.Orders;
import com.shoes.entity.Preorder;
import com.shoes.entity.Users;
import com.shoes.until.Service;

public class CheckAction extends ActionSupport {
	/**
	 * 
	 */
	private int index=1;
	private static final int clumns=10;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	Service service=null; 
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
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
		ActionContext.getContext().getValueStack().set("singleprice", service.getprice(preord.getShoeid()));;
		return SUCCESS;
	}
	public String createorder() {
		HttpServletRequest request=ServletActionContext.getRequest();
			service.addOder(this.order);
			request.setAttribute("order", this.order);
			return SUCCESS;
		
	}
	public String shopping() throws UnsupportedEncodingException, SQLException {
		HttpServletRequest request=ServletActionContext.getRequest();
		this.createpreorder();
		service.addpreorder(preord);
		List<Preorder> pds=(List<Preorder>)request.getSession().getAttribute("preorder");
		pds.add(preord);
		return SUCCESS;
	}
	public String getorders() throws SQLException {
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users u=(Users)session.getAttribute("user");
		int allordsnum = service.getorder((Users)session.getAttribute("user")).size();
		List<Orders> orders=service.getorder(index,clumns,u);
		ActionContext.getContext().getValueStack().set("maxindex",1+allordsnum/10);
		ActionContext.getContext().getValueStack().set("allordsnum",allordsnum);
		ActionContext.getContext().getValueStack().set("clumns",clumns);
		ActionContext.getContext().put("orders", orders);
		return SUCCESS;
	}
	public String cleanpreord() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Users u=(Users)request.getSession().getAttribute("user");
		if(u!=null&&!u.getName().equals("")) {
			service.cleanpreord(u);
			((List<Preorder>)request.getSession().getAttribute("preorder")).clear();
			}
		return SUCCESS;
		
	}
	public String rempreord() throws  SQLException {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		if(this.preord.getPreorderid()!=null) {
			List<Preorder> pl=(List<Preorder>)request.getSession().getAttribute("preorder");
			pl.remove(this.preord);
			service.removepreord(this.preord);
			return SUCCESS;
		}
		return ERROR;
	}
	public String getpageorders() throws SQLException {
		System.out.println("index:"+index);
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users u=(Users)session.getAttribute("user");
		int allordsnum = service.getorder((Users)session.getAttribute("user")).size();
		List<Orders> orders=service.getorder(index,clumns,u);
		ActionContext.getContext().getValueStack().set("maxindex",1+allordsnum/10);
		ActionContext.getContext().getValueStack().set("allordsnum",allordsnum);
		ActionContext.getContext().getValueStack().set("clumns",clumns);
		ActionContext.getContext().put("orders", orders);
		return SUCCESS;
	}
}

