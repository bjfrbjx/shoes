<%@ page language="java" contentType="text/html; utf-8" import="com.shoes.entity.Preorder,java.util.Set"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
<title>shopping</title>
</head>
<body>

<%@ include file="/complete/headline.jsp" %>
<table>
<thead><tr><th>订单号</th><th>用户</th><th>鞋号</th><th>购买</th><th>移除</th></tr></thead>
<%  Set<Preorder> pds=(Set<Preorder>)session.getAttribute("preorder");
;
for(Preorder pd:pds) {%>
<tr><td><%=pd.getOrderID() %></td><td><%=pd.getUsername() %></td><td><%=pd.getShoeID() %></td>
<td><a href="pay?preord.shoeID=<%=pd.getShoeID() %>">购买</a>
<td><a href="rempreord?preord.orderID=<%=pd.getOrderID() %>">移除</a>
</tr>
<%} %>
</table>

<a href="cleanpreord">清空购物车</a>
<%@ include file="/complete/footline.jsp" %>
</body>
</html>