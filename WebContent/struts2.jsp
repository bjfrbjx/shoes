<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title><s:property value="message"/></title>
  </head>
  <body>
  <p>0,lib下添加struts架包
  1   web.xml只添加struts过滤器，/*使struts代理所有业务
  2   可以在webcontent下直接编写login.jsp等视图：action="login" input name="ID"
  3   src下创建struts.xml struts-package-《action name="login" class="struts.Myaction" method="execute"》-《 result》/main.jsp《/result》
  4   类 struts.Myaction需要创建无参构造方法和ID字段并生成getID setID方法。字段提交时会先生成无参对象，再调用setID方法将提交信息赋给对象
  5	  main.jsp 使用taglib 获取 Myaction对象，再用《s:property value="ID"/》调用对象的getID方法
  </p>
  
  </body>
</html>