package com.shoes.until;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.shoes.entity.*;

public class Service {
	private DAO dao=null;
	public DAO getDao() {
		return dao;
	}
	public void setDao(DAO dao) {
		System.out.println("set daoimpl "+dao);
		this.dao = dao;
	}
	//private static final DAO dao=DAOimpl.getDAO();
	public Boolean regist(Users u){
			try {
				dao.save(u);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}
    public Boolean login(Users u){
    	if(u.getPassword()==null||u.getPassword().equals("")||u.getName()==null||u.getName().equals(""))
    		return false;
    	if(dao.getone(u)==null)
    		return false;
    	else
    		return true;
    }
    public  List<Shoes> getshoes() throws SQLException{
    	return dao.getall(Shoes.class);
    }
    public List<Orders> getorder(int index,int rows,Users u) {
    		Orders ord=new Orders();
    		ord.setUserid(u.getName());
    		return  dao.page(index, rows, ord);	
    }
    public List<Orders> getorder(Users u) {
		Orders ord=new Orders();
		ord.setUserid(u.getName());
		return  dao.gets(ord);	
}
    public List<Preorder> getpreorder(Users u) throws SQLException{
    	Preorder preord=new Preorder();
    	preord.setUserid(u.getName());
        return dao.gets(preord);
    }
    public void addpreorder(Preorder preord){
    	dao.save(preord);
    }
    public void setAccumVistors(Integer sum) {
    	dao.save(new Accumvistor(sum));
    }
    public Integer getAccumVistors() throws SQLException {
    	List<Accumvistor> list=dao.gets(new Accumvistor());
    	return list.get(list.size()-1).getSum()+1;
    }
    public void addOder(Orders ord) {
    	dao.save(ord);
    }
    public Float getprice(Shoes shoe) throws SQLException {
    	shoe=dao.getone(shoe);
    	return shoe.getPrice();
    }
    public Float getprice(String shoeid) throws SQLException {
    	Shoes shoe=new Shoes();
    	shoe.setShoeId(shoeid);
    	shoe=dao.getone(shoe);
    	return shoe.getPrice();
    }
    public void removepreord(Preorder preord) throws SQLException {
    	dao.delete(preord);
    }
    public void cleanpreord(Users u) {
    	Preorder p=new Preorder();
    	p.setUserid(u.getName());
    	dao.delete(p);
    }
    public void removeshoes(Shoes shoe) {
    	dao.delete(shoe);
    }   
    public void addstock(Shoes shoe){
    	dao.update(shoe);
    }
    public void addrep(Shoes shoe) {
    	dao.save(shoe);
    }
    public void remimg(String realpath) {
    	File f=new File(realpath);
    	if(f.exists()) {
    		f.delete();
    		System.out.println("del ok");
    	}
    	else {System.out.println("del error");}
    }
    public void addcomment(Comments c) {
    	dao.save(c);
    }
    public void delrep(Orders ord) throws SQLException {
    	//ord=dao.getone(ord);
    	Shoes shoes=new Shoes();
    	shoes.setShoeId(ord.getShoeid());
    	shoes=dao.getone(shoes);
    	Float newrep=shoes.getSize()-ord.getNum();
    	shoes.setSize(newrep);
    	dao.update(shoes);
    }
    public List<Comments> getCommentsByShoeid(String shoeid) throws SQLException{
    	Comments c=new Comments();
    	c.setShoeid(shoeid);
    	//List<Comments> comments=dao.gets(c);
    	List<Comments> comments=dao.page(0, 10, c);
    	return comments;
    }
    public List<Comments> getCommentsByUsername(String username) throws SQLException{
    	Comments c=new Comments();
    	c.setUsername(username);
    	List<Comments> comments=dao.gets(c);
    	return comments;
    }
    public <T> T getone(T o){
    	return dao.getone(o);
    }
}
