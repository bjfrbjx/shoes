<%@ page language="java" contentType="text/html; utf-8" import="com.shoes.entity.Orders"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <% Orders ord =(Orders)session.getAttribute("payingord"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<base href="http://localhost:8081/struts2/">
<title>shopping</title>
</head>
<body>
<h1>支付成功</h1>
<br/>
<h2><%=ord.toString() %></h2>
<h3>欢迎评价：</h3>
<s:form action="addcomment" namespace="/" id="form_id">
<s:token ></s:token>
<input id="message" name="comment.message" hidden="hidden"/>
    <script id="container"  type="text/plain" style="width:300px;height:100px">
    </script>

<input name="comment.shoeid" id="comment.shoeid" value="<%=ord.getShoeid() %>" hidden="hidden"/>
<s:submit value="提交"></s:submit>
</s:form>

    <script type="text/javascript" src="/struts2/JS/ueditor.config.js"></script>
    <script type="text/javascript" src="/struts2/JS/ueditor.all.js"></script>
    <script type="text/javascript">
        var ue = UE.getEditor('container');
        var messageinput=document.getElementById("message");
        ue.ready(function () {
            ue.setContent("您的评价很重要",true);
            form['editorValue'].setAttribute("disabled","true")
         });
        let form = document.getElementById('form_id');
        form.onsubmit = function(e){
        	var txt=ue.getContent().replace(new RegExp("<p>","g"), "").replace(new RegExp("</p>","g"),"").replace(new RegExp("<br/>","g"),"\n").replace(new RegExp("&nbsp;","g")," ");
            messageinput.value=txt;
        }

    </script>

</body>
</html>