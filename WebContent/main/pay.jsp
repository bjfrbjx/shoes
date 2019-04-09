<%@ page language="java" contentType="text/html; utf-8" import="com.shoes.entity.*,com.shoes.until.DB,java.util.Date"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
<title>shopping</title>
</head>
<body>
<%  
Preorder ord=(Preorder)session.getAttribute("payorder");
%>
<%@ include file="/complete/headline.jsp" %>
<form action="buy" method="post">
<ul>
<li>订单号:<input type="text" name="order.orderID" value="<%=ord.getOrderID() %>" readonly="readonly"></li>
<li>用户:<input type="text" name="order.username" value="<%=ord.getUsername() %>" readonly="readonly"></li>
<li>鞋号:<input type="text" name="order.shoeID" value="<%=ord.getShoeID() %>" readonly="readonly"></li>
<li>数量:<input id="num" type="number" name="order.num" value="1" oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"></li>
<li>下单时间:<input type="text" name="order.date" value="<%=(new Date()).toLocaleString()%>" readonly="readonly"></li>
<li>单价：<input type="number" name="order.sumpric" value="<%=DB.getprice(ord.getShoeID()) %>" readonly="readonly"></li>
<li><input type="submit" value="提交"/></li>
</ul>
</form>

<%@ include file="/complete/footline.jsp" %>
</body>
</html>