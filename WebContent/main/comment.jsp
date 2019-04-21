<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="refresh" content="5;url=/struts2/index.jsp">
</head>
<body onload="run()">
<h>评论</h>
<textarea rows="4" cols="30">
<%=session.getAttribute("message").toString() %>
</textarea>
页面将在<span id="spanId">5</span>秒后跳转！！
<script type="text/javascript">
    var x = 5;
    function run(){
        var span = document.getElementById("spanId");
        span.innerHTML = x;
        x--;
        window.setTimeout("run()", 1000);
    }
     
</script>
</body>
</html>