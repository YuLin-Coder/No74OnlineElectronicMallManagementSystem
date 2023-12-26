<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>欢迎进入系统后台</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8"><LINK 
href="../../images/syscome.files/Admin.css" rel=stylesheet>
<SCRIPT language=javascript src="../../images/syscome.files/Admin.js"></SCRIPT>

<STYLE type=text/css>.STYLE1 {
	FONT-WEIGHT: bold; COLOR: #0099ff
}
</STYLE>
<script language=javascript>
function check()
{	var orderid=document.getElementById("orderFormId").value;

		if(orderid==null||orderid==''){
		alert("编号不能为空！");
		return false;
		}

		
}</script>
<META content="MSHTML 6.00.2900.5726" name=GENERATOR></HEAD>
<BODY><BR>
<TABLE class=tableborder cellSpacing=1 cellPadding=3 width="95%" align=center 
border=0>
</TABLE><BR>
<form name="form1" method="post" action="OrderFormAction!queryOrderForm.action" onsubmit="return check();">
<TABLE cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 
border=0>
  <TBODY>
  <TR>
    <TH colSpan=9 height=24>【订单查询】
    </TH>  </TR>
  <TR>
    <TD class=forumrow><div align="right">订单编号：</div></TD>
    <TD colspan="8" class=forumrowhighlight>
      <input type="text" name="orderForm.orderFormId" id="orderFormId"></TD>
    </TR>
  <TR>
    <TD class=forumrow><div align="right">买家用户名：</div></TD>
    <TD colspan="8" class=forumrowhighlight><input type="text" name="orderForm.username"></TD>
  </TR>
  <TR>
    <TD class=forumrow><div align="right">提交订单时间：</div></TD>
    <TD colspan="8" class=forumrowhighlight><input type="text" name="orderForm.submitTime"></TD>
  </TR>
  <TR>
    <TD class=forumrow><div align="right">发货时间：</div></TD>
    <TD colspan="8" class=forumrowhighlight><input type="text" name="orderForm.consignmentTime"></TD>
  </TR>
  
  <TR>
    <TD class=forumrow>&nbsp;</TD>
    <TD colspan="8" class=forumrowhighlight><input type="submit" name="mysubmit" value="提交">
      <input type="reset" name="Submit2" value="重置"></TD>
  </TR>
  </TBODY></TABLE>
</form>  
<s:if test="#request.queryOrder==null">
<TABLE cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 border=0>

  <TBODY>
   
  <TR><td colSpan=8 align="center">没有相关信息！</td></TR></TBODY></TABLE>
</s:if>
<s:else >
<TABLE cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 
border=0>
  <TBODY>
  <% 
   	  SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
      String tm= matter.format(new Date()); %>
  <TR>
    <TH colSpan=10 height=24>【订单列表】</TH> 
   </TR>
     <TR>
    <TD class=forumrow align="center" width="8%">订单编号</TD>
    <TD class=forumrow align="center" >用户名</TD>
    <TD class=forumrow align="center" >提交订单时间</TD>
    <TD class=forumrow align="center" >发货时间</TD>
     <TD class=forumrow align="center" >订单总金额</TD>
    <TD class=forumrow align="center" >买家是否付款</TD>
    <TD class=forumrow align="center" >是否发货</TD>
    <TD class=forumrow align="center" >操作</TD> 
  </TR>
<s:iterator value="#request.queryOrder" id="queryOrder" >
  <TR>
    <TD class=forumrow height=24 align="center"><s:property value="#queryOrder.orderFormId"/></TD>
    <TD class=forumrowhighlight  height=24 align="center"><s:property value="#queryOrder.username"/></TD>
    <TD class=forumrowhighlight  height=24 align="center"><s:property value="#queryOrder.submitTime"/></TD>
    <TD class=forumrowhighlight height=24 align="center"><s:property value="#queryOrder.consignmentTime"/></TD>
    <TD class=forumrowhighlight height=24 align="center"><s:property value="#queryOrder.totalPrice"/></TD>
    <TD class=forumrowhighlight  height=24 align="center"><s:property value="#queryOrder.isPayoff"/></TD>
    <TD class=forumrowhighlight  height=24 align="center"><s:property value="#queryOrder.isConsignment"/></TD>

   <s:if test='#rqueryOrder.isPayoff=="是" && #rqueryOrder..isConsignment=="否" '><TD class=forumrowhighlight  align="center" style="height:24px;">
		<div style="margin-boottom:1px;"><form action="OrderFormAction!conOrder.action" method="post" name="myform" style="height:24px " onsubmit="return confirm('您确定要发货吗?');">
		<input type="hidden" name="orderForm.orderFormId" value='<s:property value="#queryOrder.orderFormId"/>' />
		<input type="hidden" name="orderForm.username" value='<s:property value="#queryOrder.username"/>' />
	  	<input type="hidden" name="orderForm.totalPrice" value='<s:property value="#queryOrder.totalPrice"/>' />
	  	<input type="hidden" name="orderForm.isPayoff" value='<s:property value="#queryOrder.isPayoff"/>' />
	  	<input type="hidden" name="orderForm.submitTime" value='<s:property value="#queryOrder.submitTime"/>' />
	 	<input type="hidden" name="orderForm.consignmentTime" value=" <%=tm %>"/>
	  	<input type="hidden" name="orderForm.isConsignment" value='<s:property value="#queryOrder.isConsignment"/>' />
	  	<input type="hidden" name="orderForm.remark" value='<s:property value="#queryOrder.remark"/>' />
	  <input type="submit"  value="发货"  style="height:24px;"/>
	  	</form></div></td></s:if>
		<s:elseif test=' #rqueryOrder.isPayoff=="否" '><TD class=forumrowhighlight height=24 align="center" >等待付款</td></s:elseif>
		<s:elseif test='#rqueryOrder.isConsignment=="是" '><TD class=forumrowhighlight height=24 align="center" >已经发货</td></s:elseif>
  </TR> </s:iterator>
    <TR>
    <TD class=forumrow height=24 colspan="12" align="center">
    </TD>
  </TR>
  </TBODY>
  </TABLE></s:else>
<BR>
<TABLE class=tableborder cellSpacing=1 cellPadding=3 width="95%" align=center 
border=0>
</TABLE><BR>
</BODY></HTML>
