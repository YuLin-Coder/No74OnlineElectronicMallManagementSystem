<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>欢迎进入系统后台</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="<%=basePath %>admin/images/syscome.files/Admin.css" rel=stylesheet>
<SCRIPT language=javascript src="<%=basePath %>images/syscome.files/Admin.js"></SCRIPT>

<STYLE type=text/css>.STYLE1 {
	FONT-WEIGHT: bold; COLOR: #0099ff
}
</STYLE>

<META content="MSHTML 6.00.2900.5726" name=GENERATOR></HEAD>
<BODY><BR>
<TABLE class=tableborder cellSpacing=1 cellPadding=3 width="95%" align=center border=0>
</TABLE><BR>
<TABLE cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 
border=0>
  <TBODY>
  <TR>
    <TH colSpan=2 height=24>【商品种类列表】</TH>  </TR>
  <TR>
    <TD class=forumrow width="20%" height=24><div align="center">商品种类编号</div></TD>
  <TD class=forumrowhighlight width="40%" 
      height=24><div align="center">商品种类名称</div></TD>
      <TD class=forumrowhighlight width="20%" 
      height=24><div align="center">删除</div></TD>
      <TD class=forumrowhighlight width="20%" 
      height=24><div align="center">添加</div></TD>
  </TR>
  <s:iterator value="#request.listCommodityClasses" id="listCommodityClasses" >
  <TR>
    <TD class=forumrow height=24 align="center"><s:property value="#listCommodityClasses.commodityClassId"/></TD>
    <TD class=forumrowhighlight  height=24 align="center"><s:property value="#listCommodityClasses.commodityClassName"/></TD>
  <TD class=forumrowhighlight height=24 align="center">
  <s:a href="CommodityClassAction!deleteCommodityClass.action?commodityClass.commodityClassId=%{#listCommodityClasses.commodityClassId}" onclick="return confirm('您确定要删除本商品种类吗?')">删除</s:a></TD>
    <TD class=forumrowhighlight  height=24 align="center"><a href="include/commodityClass/commodityClassAdd.jsp">添加</a></TD>
  </TR>
  </s:iterator>

  </TBODY></TABLE>
<BR>
<TABLE class=tableborder cellSpacing=1 cellPadding=3 width="95%" align=center 
border=0>
</TABLE><BR>
</BODY></HTML>
