<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello World</title>
</head>
<body>
   <h1>Hello World From Struts2</h1>
 <s:form action="login" method="post" namespace="/">
<br><s:textfield lable="name" name="user.name" >姓名</s:textfield>
<br><s:textfield lable="password" name="user.password" >密码</s:textfield>
<br><s:submit lable="Say Hello" value="提交"/>
</s:form>
</body>
</html>