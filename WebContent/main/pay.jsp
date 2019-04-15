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
<li>数量:<input id="num" type="number" name="order.num" value="1" min="0" max="10"></li>
<li>下单时间:<input type="text" name="order.date" value="<%=(new Date()).toLocaleString()%>" readonly="readonly"></li>
<li>总价：<input type="number" id="sumpric" name="order.sumpric" value="<%=DB.getprice(ord.getShoeID()) %>" readonly="readonly"></li>
<li><input type="submit" value="提交"/></li>
</ul>
</form>
<%@ include file="/complete/footline.jsp" %>
<script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js" ></script>
<script type="text/javascript">
var sin=<%=DB.getprice(ord.getShoeID()) %>
$("#num").change(function(){
    $("#sumpric").val(sin*$("#num").val());
  });
</script>
</body>
</html>