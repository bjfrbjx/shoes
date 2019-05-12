<%@ page language="java" pageEncoding="UTF-8" import="java.util.*" %>
<hr><% 
Integer CurrentOnline=(Integer) application.getAttribute("CurrentOnline");
Integer AccumVistors=(Integer) application.getAttribute("AccumVistors");
Integer LoginNum=(Integer) application.getAttribute("LoginNum");
Date date=new Date();
%>
<div class="col-lg-6 col-md-8 col-sm-6 col-xs-12 " style="clear:both">
<p>杭州留和路288号: 服务热线 : 804-377-3580 - 804-399-3580</p><br><p>日期<%=date.toLocaleString() %> - 当前访问人数:<%=CurrentOnline %> - 开服累计人次:<%=AccumVistors %> - 登陆人数：<%=LoginNum %></p> </div>
