package com.shoes.action;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shoes.entity.Comment;
import com.shoes.entity.User;
import com.shoes.until.DB;
import net.sf.json.JSONArray;

public class CommentAction extends ActionSupport {
	private String shoeid ="";
	private String result;
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
	private Comment comment=new Comment();
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
	
	}
	public CommentAction() {
		// TODO 自动生成的构造函数存根
	}
	public String subComment() {
		HttpServletRequest request =ServletActionContext.getRequest();
		String username= ((User)request.getSession().getAttribute("user")).getName();	
		if (this.comment!=null) {
			this.comment.setUsername(username);
			this.comment.setDate((new Date()).toLocaleString());
			DB.addcomment(this.comment);
			request.getSession().setAttribute("message", this.comment.getMessage());
			return SUCCESS;
		}
		else
			return ERROR;
		
	}
	public String getComments() throws SQLException {
		System.out.println(this.shoeid);
		if(!this.shoeid.equals("")) {
			List<Comment> cl=DB.getCommentsByShoeid(this.shoeid);
			System.out.println(cl.size());
			JSONArray jsonArray = JSONArray.fromObject(cl);
			result = jsonArray.toString();
			return SUCCESS;
		}
		return ERROR;
	}
	
}
