<%@ page language="java" pageEncoding="UTF-8" import="java.util.*" %>
<hr><% 
Integer CurrentOnline=(Integer) application.getAttribute("CurrentOnline");
Integer AccumVistors=(Integer) application.getAttribute("AccumVistors");
Integer LoginNum=(Integer) application.getAttribute("LoginNum");
Date date=new Date();
%>
<h3>日期<%=date.toLocaleString() %> - 当前访问人数:<%=CurrentOnline %> - 开服累计人次:<%=AccumVistors %> - 登陆人数：<%=LoginNum %></h3>