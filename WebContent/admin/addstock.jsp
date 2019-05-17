<%@ page language="java" contentType="text/html; utf-8" 
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<base href="http://localhost:8081/struts2/">
	<%@ include file="/complete/headcss.jsp" %>
<title>main</title>
</head>
<body>
<%@ include file="/complete/headline.jsp" %>
<form action="admin/addstock" method="post">
<input name="shoes.shoeId" type="text" hidden="hidden" value="<%=(String)request.getAttribute("shoeid") %>" />
<input name="shoes.size" type="number" value="0"/>
<input type="submit" value="提交">
</form>

<%@ include file="/complete/footline.jsp" %>
<script type="text/javascript" src="/struts2/JS/IEURIencode.js" ></script>
</body>
</html>