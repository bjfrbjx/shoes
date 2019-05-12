<%@ page language="java" pageEncoding="utf-8" import="com.shoes.entity.Users"%>
<% String txt=(String)request.getAttribute("error"); 
Users user=(Users)session.getAttribute("user"); 
Boolean isadmin=(Boolean)session.getAttribute("admin"); %>
<% if(txt!=null){%>
<p><%=txt %></p>
<% } %>
<div class="header--sidebar"></div>
<header class="header">
  <div class="header__top">
	<div class="container-fluid">
	  <div class="row">

			<div class="col-lg-6 col-md-4 col-sm-6 col-xs-12 ">
			  <div class="header__actions">
<%
if(user!=null){%>
Hello <%=user.getName() %>!<a href="/struts2/login.jsp">换号</a>&nbsp;&nbsp;<a href="/struts2/logout">注销</a>&nbsp;&nbsp;<a href="main/shopping.jsp">购物车</a>&nbsp;&nbsp;<a href="main/getorders">账单</a>
<% } else{%>
<a href="/struts2/login.jsp">登陆</a>&nbsp;&nbsp;<a href="regist.jsp">注册</a>
<% }%>
&nbsp;&nbsp;<a href="/struts2/index.jsp">首页</a>&nbsp;&nbsp;<a href="/struts2/main/main.jsp">主页</a>
<% if(isadmin!=null&&isadmin==true){ %>	&nbsp;&nbsp;<a href="/struts2/admin/admin.jsp">管理</a> <% }%>
				<div class="btn-group ps-dropdown">&nbsp;&nbsp;&nbsp;&nbsp;<a class="dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Language<i class="fa fa-angle-down"></i></a>
				  <ul class="dropdown-menu">
					<li><a href="#">English</a></li>
					<li><a href="#">Japanese</a></li>
					<li><a href="#">Chinese</a></li>
				  </ul>
				</div>
			  </div>
			 
			</div>
	  </div>
	</div>
  </div></header>