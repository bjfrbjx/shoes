package com.shoes.action;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.Comments;
import cn.Users;
 
import com.shoes.until.Service;

import net.sf.json.JSONArray;

public class CommentAction extends ActionSupport {
	Service service=null; 
	private String shoeid ="";
	private String result;
	String strutstoken;
	public void setStrutstoken(String token) { this.strutstoken = token; }
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public String getStrutstoken() { return strutstoken; }
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getShoeid() {
		return shoeid;
	}
	public void setShoeid(String shoeid) {
		this.shoeid = shoeid;
	}
	private Comments comment=new Comments();
	public Comments getComment() {
		return comment;
	}
	public void setComment(Comments comment) {
	
	}
	public CommentAction() {
		// TODO 自动生成的构造函数存根
	}
	public String subComment() {
		HttpServletRequest request =ServletActionContext.getRequest();
		String username= ((Users)request.getSession().getAttribute("user")).getName();	
		if (this.comment!=null) {
			if (this.comment.getMessage().equals("")) 
				return "index";
			this.comment.setUsername(username);
			this.comment.setDate((new Date()).toLocaleString());
			service.addcomment(this.comment);
			request.getSession().setAttribute("message", this.comment.getMessage());
			return SUCCESS;
		}
		else
			return ERROR;
		
	}
	public String getComments() throws SQLException {
		if(!this.shoeid.equals("")) {
			List<Comments> cl=service.getCommentsByShoeid(this.shoeid);
			JSONArray jsonArray = JSONArray.fromObject(cl);
			result = jsonArray.toString();
			
			return SUCCESS;
		}
		return ERROR;
	}
	
}
