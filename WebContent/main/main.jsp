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
<thead><tr><th>品牌</th><th>款式</th><th>价格</th><th>性别</th><th>库存</th><th>购买</th><th>购物车</th></tr></thead>
<tbody>
<%for(Shoes sh:sl) {
if(sh.getSize()>0){
%>
<tr onclick=showComments("<%=sh.getShoeID() %>")>
<td onclick=showImg("/struts2/<%=sh.getIMG() %>")><%=sh.getBrand() %></td>
<td><%=sh.getKind() %></td>
<td><%=sh.getPrice() %></td>
<td><%=sh.getSex() %></td>
<td><%=sh.getSize() %></td>
<td><a href="<%=request.getContextPath()%>/main/pay?preord.shoeID=<%=sh.getShoeID() %>">购买</a></td>
<td><a href="<%=request.getContextPath()%>/main/shopping?preord.shoeID=<%=sh.getShoeID() %>">添加购物车</a></td>

</tr>
<%}
} %>
</tbody>
</table>
<div ><img alt="tupian" src="/struts2/<%=sl.get(0).getIMG() %>" id="show">
<ul id="comments"><li>买前看一看</li></ul>
</div>

<a href="/struts2/main/shopping.jsp">购物车</a>
<a href="/struts2/main/getorders">账单</a>
<%@ include file="/complete/footline.jsp"  %>
<script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js" ></script>
<script type="text/javascript">
function showImg(src){
	var showbox=document.getElementById("show");
	showbox.setAttribute("src",src);
}

function showComments(shoeid){
	$("#comments").empty();
	$.ajax({
		type:"post",
		url:"main/getComments",
		data:{shoeid:shoeid},
		dataType:"json",
		success:function(data){
		var data2 = eval(data);
		for(var i in data2){
			$("#comments").append("<li>"+data2[i].username+":<p>"+data2[i].message+"</p></li>");
				}
			},
		error:function(data){alert("fail");},
		});
		
}
</script>

</body>
</html>