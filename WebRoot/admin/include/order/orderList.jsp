<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":" +request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>欢迎进入系统后台</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK href="<%=basePath %>admin/images/syscome.files/Admin.css" rel=stylesheet>
<SCRIPT language=javascript src="<%=basePath %>images/syscome.files/Admin.js"></SCRIPT>

<STYLE type=text/css>.STYLE1 {
	FONT-WEIGHT: bold; COLOR: #0099ff
}
</STYLE>

<META content="MSHTML 6.00.2900.5726" name=GENERATOR></HEAD>
<BODY><BR>
<TABLE class=tableborder cellSpacing=1 cellPadding=3 width="95%" align=center 
border=0>
</TABLE><BR>
<TABLE cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 
border=0>
  <TBODY> 
  <% 
   	  SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
      String tm= matter.format(new Date()); %>
  <TR>
    <TH colSpan=8 height=24>【订单列表】</TH> 
   </TR>
     <TR>
    <TD class=forumrow align="center" width="10%"  height=24>订单号</TD>
    <TD class=forumrow align="center" >用户名</TD>
    <TD class=forumrow align="center" >提交订单时间</TD>
    <TD class=forumrow align="center" >发货时间</TD>
     <TD class=forumrow align="center" >订单总金额</TD>
    <TD class=forumrow align="center" >买家是否付款</TD>
    <TD class=forumrow align="center" >是否发货</TD>
    <TD class=forumrow align="center" >买家备注</TD>
    <TD class=forumrow align="center" >操作</TD> 
  </TR>
  
   
    <s:iterator value="#request.listOrderForms" id="listOrderForms" >
    <TR>
    <TD class=forumrow height=24 align="center"><s:property value="#listOrderForms.orderFormNum"/></TD>
    <TD class=forumrowhighlight  height=24 align="center"><s:property value="#listOrderForms.username"/></TD>
    <TD class=forumrowhighlight  height=24 align="center"><s:property value="#listOrderForms.submitTime"/></TD>
    <TD class=forumrowhighlight height=24 align="center"><s:property value="#listOrderForms.consignmentTime" /> </TD>
    <TD class=forumrowhighlight height=24 align="center"><s:property value="#listOrderForms.totalPrice"/></TD>
    <TD class=forumrowhighlight  height=24 align="center"><s:property value="#listOrderForms.isPayoff"/></TD>
    <TD class=forumrowhighlight  height=24 align="center"><s:property value="#listOrderForms.isConsignment"/></TD>
	<TD class=forumrowhighlight  height=24 align="center"><s:property value="#listOrderForms.remark"/></TD>
  <s:if test='#listOrderForms.isPayoff=="是" && #listOrderForms.isConsignment=="否" '><TD class=forumrowhighlight  align="center" style="height:24px;">
		<div style="margin-boottom:1px;"><form action="OrderFormAction!conOrder.action" method="post" name="myform" style="height:24px " onsubmit="return confirm('您确定要发货吗?');">
		<input type="hidden" name="orderForm.orderFormId" value='<s:property value="#listOrderForms.orderFormId"/>' />
		<input type="hidden" name="orderForm.orderFormNum" value='<s:property value="#listOrderForms.orderFormNum"/>' />
		<input type="hidden" name="orderForm.username" value='<s:property value="#listOrderForms.username"/>'/>
	  	<input type="hidden" name="orderForm.totalPrice" value='<s:property value="#listOrderForms.totalPrice"/>' />
	  	<input type="hidden" name="orderForm.isPayoff" value='<s:property value="#listOrderForms.isPayoff"/>' />
	  	<input type="hidden" name="orderForm.submitTime" value='<s:property value="#listOrderForms.submitTime"/>' />
	 	<input type="hidden" name="orderForm.consignmentTime" value="<%=tm %>"/>
	  	<input type="hidden" name="orderForm.isConsignment" value='<s:property value="#listOrderForms.isConsignment"/>' />
	  	<input type="hidden" name="orderForm.remark" value='<s:property value="#listOrderForms.remark"/>' />
	  <input type="submit"  value="发货"  style="height:24px;"/>
	  	</form></div></td></s:if>
		<s:elseif test='#listOrderForms.isPayoff=="否" '><TD class=forumrowhighlight height=24 align="center" >等待付款</td></s:elseif>
		<s:elseif test='#listOrderForms.isConsignment=="是" '><TD class=forumrowhighlight height=24 align="center" >已经发货</td></s:elseif>
 </TR>
  </s:iterator>
  
    <TR>
    <TD class=forumrow height=24 colspan="12" align="center">
    </TD>
  </TR>
  </TBODY>
  </TABLE>
<BR>
<TABLE class=tableborder cellSpacing=1 cellPadding=3 width="95%" align=center 
border=0>
</TABLE><BR>
</BODY></HTML>

