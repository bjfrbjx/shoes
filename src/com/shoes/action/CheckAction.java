package com.shoes.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shoes.entity.Order;
import com.shoes.entity.Preorder;
import com.shoes.entity.User;
import com.shoes.until.DB;

public class CheckAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -493214965117151809L;
	private Preorder preord=new Preorder();
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	private Order order=new Order();
	public Preorder getPreord() {
		return preord;
	}
	public void setPreord(Preorder preord) {
		this.preord = preord;
	}
	public CheckAction() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public String createpreorder() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String username= ((User)request.getSession().getAttribute("user")).getName();	
		String orderID=username+"-"+Integer.toHexString((int) (Math.random()*1000))+"-"+this.preord.getShoeID();
		this.preord.setUsername(username);
		this.preord.setOrderID(orderID);
		request.getSession().setAttribute("payorder",preord);
		return SUCCESS;
	}
	public String createorder() {
		HttpServletRequest request=ServletActionContext.getRequest();
			DB.addOder(this.order);
			request.setAttribute("order", this.order);
			return SUCCESS;
		
	}
	public String shopping() {
		HttpServletRequest request=ServletActionContext.getRequest();
		this.createpreorder();
		DB.addpreorder(preord);
		Set<Preorder> pds=(Set<Preorder>)request.getSession().getAttribute("preorder");
		pds.add(preord);
		return SUCCESS;
	}
	
	public String cleanpreord() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String username=((User)request.getSession().getAttribute("user")).getName();
		if(username!=null&&!username.equals("")) {
			try {
				DB.cleanpreord(username);
				((Set<Preorder>)request.getSession().getAttribute("preorder")).clear();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		return SUCCESS;
		
	}
	public String rempreord() throws UnsupportedEncodingException {
		HttpServletRequest request=ServletActionContext.getRequest();
		String preordID=this.preord.getOrderID();
		if(preordID!=null) {
			Set<Preorder> pl=(Set<Preorder>)request.getSession().getAttribute("preorder");
			pl.remove(this.preord);
		try {
			DB.removepreord(preordID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return SUCCESS;
	}
	}

