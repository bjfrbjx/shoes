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
<form action="admin/addstock" method="post">
<input name="shoes.shoeID" type="text" hidden="hidden" value="<%=(String)request.getAttribute("shoeid") %>" />
<input name="shoes.size" type="number" value="0"/>
<input type="submit" value="提交">
</form>

<%@ include file="/complete/footline.jsp" %>
</body>
</html>