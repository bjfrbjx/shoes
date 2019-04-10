<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
<title>登陆</title>
</head>
<body>
 <s:form action="regist" method="post" namespace="/" theme="xhtml">
<br/>姓名<s:textfield lable="user.name" name="user.name" ></s:textfield>
<br/>密码<s:textfield lable="user.password" name="user.password" ></s:textfield>
<br/>邮箱<s:textfield lable="user.email" name="user.email" ></s:textfield>
<s:radio list="#{'男':'先生','女':'女士'}" name="user.sex" value="男"/>
<br/><s:submit lable="Say Hello" value="提交"/>
</s:form>
<hr/>
</body>
</html>