<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
  <TR>
    <TH colSpan=10 height=24>【留言列表】</TH> 
   </TR>
     <TR>
    <TD class=forumrow align="center" width="8%">留言编号</TD>
    <TD class=forumrow align="center" >留言用户</TD>
    <TD class=forumrow align="center" >留言时间</TD>
    <TD class=forumrow align="center" >留言标题</TD>
     <TD class=forumrow align="center">留言内容</TD>
    <TD class=forumrow align="center" >操作</TD>
   
  </TR>
    <s:iterator value="#request.listMessages" id="listMessages" >
  <TR>
    <TD class=forumrow height=24 align="center"><s:property value="#listMessages.messageId"/></TD>
    <TD class=forumrowhighlight  height=24 align="center"><s:property value="#listMessages.username"/></TD>
    <TD class=forumrowhighlight  height=24 align="center"><s:property value="#listMessages.messagetime"/></TD>
      <TD class=forumrowhighlight height=24 align="center"><s:property value="#listMessages.messagetitle"/></TD>
    <TD class=forumrowhighlight  height=24 align="center"><s:property value="#listMessages.messagetext"/></TD>
  <TD class=forumrowhighlight height=24 align="center">
  <s:a href="MessageAction!deleteMessage.action?message.messageId=%{#listMessages.messageId}" onclick="return confirm('您确定要删除吗?')">删除</s:a></TD>
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

