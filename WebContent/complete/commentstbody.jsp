<%@ page language="java" pageEncoding="utf-8" import="com.shoes.entity.Users" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<table  class="altrowstable">
<thead><tr><th>序号</th><th>订单号</th><th>用户</th><th>鞋号</th><th>数量</th><th>总价<th>下单日期</th></tr></thead>
<tbody>
<s:set id="icr" value="0"></s:set>
<s:iterator value="orders">
<s:set id="icr" value="#icr+1"></s:set>
<tr>
<td><s:property value="%{(index-1)*clumns+#icr}"/></td>
<td><s:property value="orderid"/></td>
<td><s:property value="userid"/></td>
<td><s:property value="shoeid"/></td>
<td><s:property value="num"/></td>
<td><s:property value="sumpric"/></td>
<td><s:property value="date"/></td>
</tr>
</s:iterator>
</tbody>
</table>

目录： <s:property value="index"/> 总页：<s:property value="maxindex"/> 总记录：<s:property value="allordsnum"/>

