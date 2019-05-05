<%@ page language="java" contentType="text/html; utf-8" 
    pageEncoding="utf-8"%>
   <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>shopping</title>
<s:head/>
<sx:head/>
</head>
<body>

<%@ include file="/complete/headline.jsp" %>
<br>
<iframe src="/struts2/main/getpageorders?index=1" name="view_frame" width="700px" height="400px"></iframe> 
<br>
<s:textfield label="跳转" type="number" value="%{index}" id="targetindex"></s:textfield>
<a id="findindex" href="/struts2/main/getpageorders?index=1" target="view_frame">跳转</a>
<br>
<%@ include file="/complete/footline.jsp" %>
<script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js" ></script>
<script type="text/javascript">
window.onload=function(){
	$("body").delegate("#targetindex","change",function (){
		$("#findindex").attr("href","/struts2/main/getpageorders?index="+$("#targetindex").val());
		//$("#findindex").removeAttr("disabled");
		$('#findindex').text("跳至："+$("#targetindex").val());
});
	console.log(targetindex);
}
</script>
</body>
</html>