package com.shoes.action;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import java.io.File;
import java.io.IOException;
import com.opensymphony.xwork2.ActionSupport;
import com.shoes.entity.Shoes;
import com.shoes.until.Service;

import org.apache.commons.io.FileUtils;

public class AdminAction extends ActionSupport {
private Service service=null; 
private static final String imgdir=ServletActionContext.getServletContext().getRealPath("/IMG");
private Shoes shoes=new Shoes();
private File imgfile=null;
private String imgfileContentType;
private String imgfileFileName;
public Shoes getShoes() {
	return shoes;
}
public void setShoes(Shoes shoes) {
	this.shoes = shoes;
}
public File getImgfile() {
	return imgfile;
}
public void setImgfile(File imgfile) {
	this.imgfile = imgfile;
}
public String getImgfileContentType() {
	return imgfileContentType;
}
public void setImgfileContentType(String imgfileContentType) {
	this.imgfileContentType = imgfileContentType;
}
public Service getService() {
	return service;
}
public void setService(Service service) {
	this.service = service;
}
public String getImgfileFileName() {
	return imgfileFileName;
}
public void setImgfileFileName(String imgfileFileName) {
	this.imgfileFileName = imgfileFileName;
}
	public AdminAction() {
	}
	public String addrep() throws SQLException, IOException {
		HttpServletRequest request =ServletActionContext.getRequest();
		this.shoes.setSrc("IMG/"+imgfileFileName);
		service.addrep(this.shoes);
		File newimg=new File(imgdir,imgfileFileName);
		if(!newimg.exists())FileUtils.copyFile(imgfile, newimg);
		List<Shoes> sl=(List<Shoes>)request.getSession().getAttribute("Shoeslist");
		sl.add(this.shoes);
		return SUCCESS;
	}
	public String withdraw() {
		HttpServletRequest request =ServletActionContext.getRequest();
		List<Shoes> sl=(List<Shoes>)request.getSession().getAttribute("Shoeslist");
		if(this.shoes.getShoeId()!=null&&!this.shoes.getShoeId().equals("")) {
		String imgsrc= ServletActionContext.getServletContext().getRealPath(this.shoes.getSrc());
		service.removeshoes(this.shoes);
		service.remimg(imgsrc);
		sl.remove(this.shoes);
	}
		return SUCCESS;
	}
	public String addstock() throws SQLException {
		HttpServletRequest request =ServletActionContext.getRequest();
		if(this.shoes.getShoeId()==null)
			return "error";
		if(this.shoes.getSize()==null||this.shoes.getSize()==0.0f) {
		request.setAttribute("shoeid", this.shoes.getShoeId());
			return "continue";
		}
		else {
			System.out.println("start addstock "+this.shoes);
			Shoes temp=new Shoes();
			temp.setShoeId(this.shoes.getShoeId());
			temp=service.getone(temp);
			System.out.println("old staock"+temp.getSize());
			temp.setSize(this.shoes.getSize()+temp.getSize());
			service.addstock(temp);
			List<Shoes> sl=(List<Shoes>)request.getSession().getAttribute("Shoeslist");
			sl.set(sl.indexOf(temp), temp);
			return SUCCESS;
		}
	}
}
