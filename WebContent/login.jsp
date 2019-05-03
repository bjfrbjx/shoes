<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>shoes store</title>
</head>
<body>

<%@ include file="/complete/headline.jsp" %>
<h1>登录</h1>
 <s:form action="login" method="post" namespace="/" >
<s:textfield label="name" name="user.name" ></s:textfield>
<s:textfield label="password" name="user.password" ></s:textfield>
<br/><s:submit label="Say Hello" value="提交"/>
</s:form>
<%@ include file="/complete/footline.jsp" %>
</body>
</html>