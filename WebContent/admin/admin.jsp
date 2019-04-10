<%@ page language="java" contentType="text/html; utf-8" import="com.shoes.entity.*,com.shoes.until.DB,java.util.List"
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
<% User u=(User)session.getAttribute("user");
List<Shoes> sl=DB.getshoes();
%>
<table>
<thead><tr><th>鞋号<th>品牌</th><th>款式</th><th>价格</th><th>性别</th><th>下架</th></tr></thead>
<tbody>
<%for(Shoes sh:sl) {%>
<tr onclick=showImg("/struts2/<%=sh.getIMG() %>")>
<td><%=sh.getShoeID() %></td>
<td><%=sh.getBrand() %></td>
<td><%=sh.getKind() %></td>
<td><%=sh.getPrice() %></td>
<td><%=sh.getSex() %></td>
<td><a href="<%=request.getContextPath() %>/admin/withdraw?shoes.shoeID=<%=sh.getShoeID() %>&shoes.IMG=<%=sh.getIMG() %>">下架</a></td>
</tr>
<%} %>
</tbody>
</table>
<div ><img alt="tupian" src="/struts2/IMG/a.jpg" id="show"></div>
<hr/>
<s:form action="addrep" enctype="multipart/form-data" method="post" namespace="/admin" >
<ul>
<li>鞋号<input type="text" name="shoes.shoeID" ></li>
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
<script type="text/javascript">
function showImg(src){
	var showbox=document.getElementById("show");
	showbox.setAttribute("src",src);
}

</script>
admin
</body>
</html>