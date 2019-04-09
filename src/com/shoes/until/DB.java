package com.shoes.until;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.shoes.entity.Order;
import com.shoes.entity.Preorder;
import com.shoes.entity.Shoes;
import com.shoes.entity.User;

public class DB {
	private static final String url="jdbc:mysql://localhost:3306/test?useSSL=false";
	private static final String user="root";
	private static final String password="root";
	static Connection con=null;
	static Statement sta=null;
	static List<Shoes> sl=null;
	static List<Order> ol=null;
	static {	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
			sta=con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			;
			e.printStackTrace();
		}
	}
	public static Boolean regist(String name,String sex,String password,String email) throws SQLException {
		Boolean r=false;
		ResultSet cours=sta.executeQuery("select * from users where name=\""+name+"\"");
		if(cours.next()) {cours.close();return null;}
		String sql ="insert into users(name,email,sex,password) values (?,?,?,?)";
		PreparedStatement pst=null;
		try {
			pst=con.prepareStatement(sql);    
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, sex);
			pst.setString(4, password);
			pst.executeUpdate();
			r=true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			try {
				if (pst!=null) 
						pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		pst.close();
		return r;
	}
    public static Boolean login(String name,String password) throws SQLException {
    	ResultSet cours=sta.executeQuery("select password from users where name=\""+name+"\"");
		if(!cours.next()) {cours.close();return false;}
		else if(!cours.getString(1).equals(password)) {cours.close();return false;}
		else  return true;
    }
    public static List<Shoes> getshoes() throws SQLException{
    	if(sl==null) {
    	sl=new ArrayList<Shoes>();
    	}
    	sl.clear();
    	ResultSet cours=sta.executeQuery("select * from shoes");
    	while(cours.next()) {
    		sl.add(new Shoes(cours.getString("brand"),cours.getFloat("size"),cours.getString("kind"),cours.getString("sex"),cours.getString("shoeID"),cours.getString("src"),cours.getFloat("price")));
    	;
    	}
    	cours.close();
		return sl;
    }
    public static List<Order> getorder(User u) throws SQLException{
    	if(ol==null) {
        	ol=new ArrayList<Order>();
    	}
        	ResultSet cours=sta.executeQuery("select * from orders where userid=\""+u.getName()+"\"");
        	while(cours.next()) {
        		ol.add(new Order(cours.getString("orderid"),cours.getString("userid"),cours.getString("shoeid"),cours.getInt("num"),cours.getString("date"),cours.getFloat("sumpric")));
        	}
        	cours.close();
    		return ol;
    }
    public static Set<Preorder> getpreorder(User u) throws SQLException{
        	HashSet<Preorder> pl=new HashSet<Preorder>();
        	ResultSet cours=sta.executeQuery("select * from preorder where userid=\""+u.getName()+"\"");
        	while(cours.next()) {
        		pl.add(new Preorder(cours.getString("preorderid"),cours.getString("userid"),cours.getString("shoeID")));
        	}
        	cours.close();
        	System.out.print("DB");System.out.println(pl.size());
    		return pl;
    }
    public static void addpreorder(Preorder pd){
    	String sql ="insert into preorder(preorderid,userid,shoeid) values (?,?,?)";
		PreparedStatement pst=null;
		try {
			pst=con.prepareStatement(sql);    
			pst.setString(1, pd.getOrderID());
			pst.setString(2, pd.getUsername());
			pst.setString(3, pd.getShoeID());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			try {
				if (pst!=null) 
						pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
    public static void setAccumVistors(Integer sum) {
    	String sql ="update accumvistor set sum=?";
		PreparedStatement pst=null;
		try {
			pst=con.prepareStatement(sql);
			;
			pst.setInt(1, sum);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    }
    public static Integer getAccumVistors() throws SQLException {
    	ResultSet cours=sta.executeQuery("select sum from accumvistor order by sum");
    	if(cours.next()) {
    		return new Integer(cours.getInt("sum"));
    	}
    	else return null;
    }
    public static void addOder(Order ord) {
    	String sql ="insert into orders(orderid,userid,shoeid,num,date,sumpric) values (?,?,?,?,?,?)";
    	PreparedStatement pst=null;
		try {
			pst=con.prepareStatement(sql);    
			pst.setString(1, ord.getOrderID());
			pst.setString(2, ord.getUsername());
			pst.setString(3, ord.getShoeID());
			pst.setInt(4, ord.getNum());
			pst.setString(5, ord.getDate());
			pst.setFloat(6, ord.getSumpric());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			try {
				if (pst!=null) 
						pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	
    };
    public static Float getprice(String shoeID) throws SQLException {
    	ResultSet cours=sta.executeQuery("select price from shoes where shoeID=\""+shoeID+"\"");
		if(!cours.next()) {cours.close();return null;}
		else {Float f=cours.getFloat(1);cours.close();return f;}
    }
    public static void removepreord(String preordID) throws SQLException {
    	String sql="delete from preorder where preorderid=\""+preordID+"\"";
    	sta.executeUpdate(sql);
    }
    public static void cleanpreord(String username) throws SQLException {
    	String sql="delete from preorder where userid=\""+username+"\"";
    	sta.executeUpdate(sql);
    }
    public static void removeshoes(String shoeID) throws SQLException {
    	String sql="delete from shoes where shoeID=\""+shoeID+"\"";
    	int l=sta.executeUpdate(sql);
    }
    public static void addrep(Shoes shoe) throws SQLException{
    	String sql ="insert into shoes(brand,size,kind,sex,price,shoeID,src) values (?,?,?,?,?,?,?)";
		PreparedStatement pst=null;
    	pst=con.prepareStatement(sql);
    	pst.setString(1, shoe.getBrand());
    	pst.setFloat(2, shoe.getSize());
    	pst.setString(3, shoe.getKind());
    	pst.setString(4, shoe.getSex());
    	pst.setFloat(5, shoe.getPrice());
    	pst.setString(6, shoe.getShoeID());
    	pst.setString(7, shoe.getIMG());
    	pst.executeUpdate();
    }
    public static void remimg(String realpath) {
    	File f=new File(realpath);
    	if(f.exists()) {
    		;
    	}
    	else {;}
    }
}
