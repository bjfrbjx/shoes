<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<h>评论</h>
<textarea rows="4" cols="30">
<%=session.getAttribute("message").toString() %>
</textarea>
</body>
</html>