<%@ page language="java" contentType="text/html; utf-8" import="cn.*,com.shoes.until.Service,java.util.List"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
<title>main</title>
</head>
<body >
<%@ include file="/complete/headline.jsp" %>
<% Users u=(Users)session.getAttribute("user");
List<Shoes> sl=Service.getshoes();
%>
<table>
<thead><tr><th>品牌</th><th>款式</th><th>价格</th><th>性别</th><th>库存</th><th>购买</th><th>购物车</th></tr></thead>
<tbody>
<%for(Shoes sh:sl) {
if(sh.getSize()>0){
%>
<tr onclick=showComments("<%=sh.getShoeId() %>")>
<td onclick=showImg("/struts2/<%=sh.getSrc() %>")><%=sh.getBrand() %></td>
<td><%=sh.getKind() %></td>
<td><%=sh.getPrice() %></td>
<td><%=sh.getSex() %></td>
<td><%=sh.getSize() %></td>
<td><a class="link" href="<%=request.getContextPath()%>/main/pay?preord.shoeid=<%=sh.getShoeId() %>">购买</a></td>
<td><a class="link" href="<%=request.getContextPath()%>/main/shopping?preord.shoeid=<%=sh.getShoeId() %>">添加购物车</a></td>

</tr>
<%}
} %>
</tbody>
</table>
<div ><img alt="tupian" src="/struts2/<%=sl.get(0).getSrc() %>" id="show">
<ul id="comments"><li>买前看一看</li></ul>
</div>

<a href="/struts2/main/shopping.jsp">购物车</a>
<a href="/struts2/main/getorders">账单</a>
<%@ include file="/complete/footline.jsp"  %>
<script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js" ></script>
<script type="text/javascript" src="JS/IEURIencode.js" ></script>
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
		var data = eval(data);
		for(var i in data){
			$("#comments").append("<li><pre>"+data[i].date+"  "+data[i].username+"  "+data[i].message+"</pre></li>");
				}
			},
		error:function(data){alert("fail");},
		});
		
}

</script>

</body>
</html>