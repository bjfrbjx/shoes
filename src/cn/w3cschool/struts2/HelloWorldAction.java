package cn.w3cschool.struts2;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 21L;
	private String name;
	private String message;
	private Date birthday;
	   public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute() throws Exception {
		   this.message="struts";
	      return SUCCESS;
	   }
	   
	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
		   ;
	      this.name = name;
	   }

}
