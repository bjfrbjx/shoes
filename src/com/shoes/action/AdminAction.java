package com.shoes.action;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import java.io.File;
import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;
import com.shoes.entity.Shoes;
import com.shoes.until.DB;
import org.apache.commons.io.FileUtils;

public class AdminAction extends ActionSupport {
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
		Date date=new Date();
		this.shoes.setIMG("IMG/"+imgfileFileName);
		DB.addrep(this.shoes);
		File newimg=new File(imgdir,imgfileFileName);
		;
		if(!newimg.exists())FileUtils.copyFile(imgfile, newimg);
		List<Shoes> sl=(List<Shoes>)request.getSession().getAttribute("Shoeslist");
		;
		sl.add(this.shoes);
		return SUCCESS;
	}
	public String withdraw() {
		HttpServletRequest request =ServletActionContext.getRequest();
		List<Shoes> sl=(List<Shoes>)request.getSession().getAttribute("Shoeslist");
		if(this.shoes.getShoeID()!=null&&!this.shoes.getShoeID().equals("")) {
		try {
			String imgsrc= ServletActionContext.getServletContext().getRealPath(this.shoes.getIMG().replace("..", ""));
			;
			DB.removeshoes(this.shoes.getShoeID());
			DB.remimg(imgsrc);
			sl.remove(this.shoes);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		return SUCCESS;
	}
}
