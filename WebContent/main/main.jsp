<%@ page language="java" contentType="text/html; utf-8" import="com.shoes.entity.*,com.shoes.until.DB,java.util.List"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
<title>main</title>
</head>
<body>
<%@ include file="/complete/headline.jsp" %>
<% User u=(User)session.getAttribute("user");
List<Shoes> sl=DB.getshoes();
%>
<table>
<thead><tr><th>品牌</th><th>款式</th><th>价格</th><th>性别</th><th>购买</th><th>购物车</th></tr></thead>
<tbody>
<%for(Shoes sh:sl) {%>
<tr>
<td onclick=showImg("/struts2/<%=sh.getIMG() %>")><%=sh.getBrand() %></td>
<td><%=sh.getKind() %></td>
<td><%=sh.getPrice() %></td>
<td><%=sh.getSex() %></td>
<td><a href="<%=request.getContextPath()%>/main/pay?preord.shoeID=<%=sh.getShoeID() %>">购买</a></td>
<td><a href="<%=request.getContextPath()%>/main/shopping?preord.shoeID=<%=sh.getShoeID() %>">添加购物车</a></td>
</tr>
<%} %>
</tbody>
</table>
<div ><img alt="tupian" src="/struts2/<%=sl.get(0).getIMG() %>" id="show"></div>

<a href="/struts2/main/shopping.jsp">购物车</a>
<%@ include file="/complete/footline.jsp"  %>
<script type="text/javascript">
function showImg(src){
	var showbox=document.getElementById("show");
	showbox.setAttribute("src",src);
}

</script>
</body>
</html>