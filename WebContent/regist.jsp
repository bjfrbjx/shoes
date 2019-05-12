<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
<title>注册</title>
</head>
<body>
<%@ include file="/complete/headline.jsp" %>
<h1>注册</h1>
 <s:form action="regist" method="post" namespace="/" theme="xhtml">
<br/><s:textfield label="姓名" name="user.name" ></s:textfield>
<br/><s:textfield label="密码" name="user.password" ></s:textfield>
<br/><s:textfield label="邮箱" name="user.email" ></s:textfield>
<s:radio label="性别" list="#{'男':'先生','女':'女士'}" name="user.sex" value="男"/>
<br/><s:submit label="submit" value="提交"/>
<s:token ></s:token>
</s:form>
<hr/>
<%@ include file="/complete/footline.jsp" %>
</body>
</html>