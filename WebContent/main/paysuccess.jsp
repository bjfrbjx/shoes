<%@ page language="java" contentType="text/html; utf-8" import="com.shoes.entity.*,java.util.Date"
    pageEncoding="utf-8"%>
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
<h2><%=((Order)request.getAttribute("order")).toString() %></h2>
<%@ include file="/complete/footline.jsp" %>
</body>
</html>