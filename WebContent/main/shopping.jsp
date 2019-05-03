<%@ page language="java" contentType="text/html; utf-8" import="com.shoes.entity.Preorder,java.util.List"
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
<%  List<Preorder> pds=(List<Preorder>)session.getAttribute("preorder");
for(Preorder pd:pds) {%>
<tr><td><%=pd.getPreorderid() %></td><td><%=pd.getUserid() %></td><td><%=pd.getShoeid() %></td>
<td><a class="link" href="pay?preord.shoeid=<%=pd.getShoeid() %>&preord.preorderid=<%=pd.getPreorderid() %>">购买</a>
<td><a class="link" href="rempreord?preord.preorderid=<%=pd.getPreorderid() %>">移除</a>
</tr>
<%} %>
</table>

<a href="cleanpreord">清空购物车</a>
<%@ include file="/complete/footline.jsp" %>
<script type="text/javascript" src="/JS/IEURIencode.js" ></script>
</body>
</html>