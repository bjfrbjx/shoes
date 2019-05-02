<%@ page language="java" contentType="text/html; utf-8" import="cn.*,com.shoes.until.Service,java.util.List"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
<title>main</title>
</head>
<body>
<%@ include file="/complete/headline.jsp" %>
<% Users u=(Users)session.getAttribute("user");
List<Shoes> sl=(List<Shoes>)session.getAttribute("Shoeslist");
%>
<table>
<thead><tr><th>鞋号<th>品牌</th><th>款式</th><th>价格</th><th>性别</th><th>库存</th><th>下架</th><th>增库</th></tr></thead>
<tbody>
<%for(Shoes sh:sl) {%>
<tr onclick=showImg("/struts2/<%=sh.getSrc() %>")>
<td><%=sh.getShoeId() %></td>
<td><%=sh.getBrand() %></td>
<td><%=sh.getKind() %></td>
<td><%=sh.getPrice() %></td>
<td><%=sh.getSex() %></td>
<td><%=sh.getSize() %></td>
<td><a class="link" href="<%=request.getContextPath() %>/admin/withdraw?shoes.shoeId=<%=sh.getShoeId() %>&shoes.src=<%=sh.getSrc() %>">下架</a></td>
<td><a class="link" href="<%=request.getContextPath() %>/admin/addstock?shoes.shoeId=<%=sh.getShoeId() %>">添库存</a></td>
</tr>
<%} %>
</tbody>
</table>
<div ><img alt="tupian" src="/struts2/IMG/a.jpg" id="show"></div>
<hr/>
<s:form action="addrep" enctype="multipart/form-data" method="post" namespace="/admin" >
<ul>
<li>鞋号<input type="text" name="shoes.shoeId" ></li>
<li>性别<input type="text" name="shoes.sex" ></li>
<li>款式<input type="text" name="shoes.kind" ></li>
<li>品牌<input type="text" name="shoes.brand" ></li>
<li>单价<input type="number" name="shoes.price" ></li>
<li>库存<input type="number" name="shoes.size" ></li>
<li>照片<input type="file" name="imgfile" accept="image/jpeg,image/gif,image/png" ></li>
</ul>
<button type="submit">sub</button>
<button type="reset">reset</button>
</s:form>

<%@ include file="/complete/footline.jsp"  %>
<script type="text/javascript" src="JS/IEURIencode.js" ></script>
<script type="text/javascript">
function showImg(src){
	var showbox=document.getElementById("show");
	showbox.setAttribute("src",src);
}
</script>
</body>
</html>