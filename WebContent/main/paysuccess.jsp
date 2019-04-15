<%@ page language="java" contentType="text/html; utf-8" import="com.shoes.entity.*,java.util.Date"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <% Order ord =(Order)request.getAttribute("order"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
<title>shopping</title>
</head>
<body>
<%@ include file="/complete/headline.jsp" %>
<h1>支付成功</h1>
<br/>
<h2><%=ord.toString() %></h2>
<h3>欢迎评价：</h3>
<s:form action="addcomment" namespace="/">
<s:token name="dojo" ></s:token>
<s:textarea name="comment.message"></s:textarea>
<input name="comment.shoeid" value="<%=ord.getShoeID() %>" hidden="hidden"/>
<s:submit value="提交"></s:submit>
</s:form>
<%@ include file="/complete/footline.jsp" %>
</body>
</html>