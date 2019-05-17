<%@ page language="java" contentType="text/html; utf-8" import="com.shoes.entity.Preorder,com.shoes.until.Service,java.util.Date"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	
	<base href="http://localhost:8081/struts2/main">
	<%@ include file="/complete/headcss.jsp" %>
<title>shopping</title>
</head>
<body>
<%  
Preorder ord=(Preorder)session.getAttribute("payorder");
%>
<%@ include file="/complete/headline.jsp" %>
<!-- <form action="buy" method="post"> -->
<form action="main/testpay" method="post" >
<ul>
<li>订单号:<input type="text" name="order.orderid" value="<%=ord.getPreorderid() %>" readonly="readonly"></li>
<li>用户:<input type="text" name="order.userid" value="<%=ord.getUserid() %>" readonly="readonly"></li>
<li>鞋号:<input type="text" name="order.shoeid" value="<%=ord.getShoeid() %>" readonly="readonly"></li>
<li>商品规格:<input type="text" name="order.subject" value="<s:property value="subject"/>" readonly="readonly"></li>
<li>数量:<input id="num" type="number" name="order.num" value="1" min="0" max="10"></li>
<li>下单时间:<input type="text" name="order.date" value="<%=(new Date()).toLocaleString()%>" readonly="readonly"></li>
<li>总价：<input type="number" id="sumpric" name="order.sumpric" value="<s:property value="singleprice"/>" readonly="readonly"></li>
<li><input type="submit" value="提交"/></li>
</ul>
</form>
<%@ include file="/complete/footline.jsp" %>
<script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js" ></script>
<script type="text/javascript">
var sin=$("#sumpric").val();
$("#num").change(function(){
    $("#sumpric").val(sin*$("#num").val());
  });
</script>
</body>
</html>