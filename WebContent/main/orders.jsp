<%@ page language="java" contentType="text/html; utf-8" 
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
<thead><tr><th>订单号</th><th>用户</th><th>鞋号</th><th>数量</th><th>总价<th>下单日期</th></tr></thead>
<tbody>
<s:iterator value="orders">
<tr>
<td><s:property value="orderid"/></td>
<td><s:property value="userid"/></td>
<td><s:property value="shoeid"/></td>
<td><s:property value="num"/></td>
<td><s:property value="sumpric"/></td>
<td><s:property value="date"/></td>
</tr>
</s:iterator>
</tbody>
</table>
<%@ include file="/complete/footline.jsp" %>
</body>
</html>