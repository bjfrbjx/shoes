<%@ page language="java" contentType="text/html; utf-8" import="com.shoes.entity.Preorder,java.util.Set"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
<title>shopping</title>
</head>
<body>

<%@ include file="/complete/headline.jsp" %>
<table>
<thead><tr><th>订单号</th><th>用户</th><th>鞋号</th><th>下单日期</th></tr></thead>
<tbody>
<s:iterator value="orders">
<tr>
<td><s:property value="orderID"/></td>
<td><s:property value="username"/></td>
<td><s:property value="shoeID"/></td>
<td><s:property value="date"/></td>
</tr>
</s:iterator>
</tbody>
</table>
<%@ include file="/complete/footline.jsp" %>
</body>
</html>