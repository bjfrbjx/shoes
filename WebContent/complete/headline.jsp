<%@ page language="java" pageEncoding="utf-8" import="com.shoes.entity.User"%>
<% String txt=(String)request.getAttribute("error"); 
User user=(User)session.getAttribute("user"); 
Boolean isadmin=(Boolean)session.getAttribute("admin");
if(txt!=null){%>
<p><%=txt %></p>
<% } %>
<%
if(user!=null){%>
Hello <%=user.getName() %>!<a href="/struts2/login.jsp">换号</a>---<a href="/struts2/logout">注销</a>---<a href="/struts2/index.jsp">首页</a>---<a href="/struts2/main/main.jsp">主页</a>
<% } else{%>
<a href="/struts2/login.jsp">登陆</a>---<a href="/struts2/regist.jsp">注册</a>---<a href="/struts2/index.jsp">首页</a>---<a href="/struts2/main/main.jsp">主页</a>
<% }%>
<% if(isadmin!=null&&isadmin==true){ %>	<a href="/struts2/admin/admin.jsp">管理</a> <% }%>