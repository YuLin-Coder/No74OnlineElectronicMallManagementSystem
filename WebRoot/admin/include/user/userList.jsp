<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <TH colSpan=8 height=24>【用户列表】 </TH> 
   </TR>
     <TR>
    <TD class=forumrow align="center" width="8%">用户编号</TD>
    <TD class=forumrow align="center" width="15%">用户名</TD>
    <TD class=forumrow align="center" width="10%">姓名</TD>
    <TD class=forumrow align="center" width="10%">性别</TD>
    <TD class=forumrow align="center" width="10%">联系电话</TD>
    <TD class=forumrow align="center" width="18%">邮寄地址</TD>
    <TD class=forumrow align="center" colspan="2" width="12%">操作</TD>
  </TR>
   <s:if test="#request.listUsers.isEmpty">
 <div><h3>没有相关信息！</h3></div> 
  </s:if><s:else>
    <s:iterator value="#request.listUsers" id="listUsers" >
  <TR>
    <TD class=forumrow height=24 align="center"><s:property value="#listUsers.userId"/></TD>
    <TD class=forumrowhighlight  height=24 align="center"><s:property value="#listUsers.username"/></TD>
    <TD class=forumrowhighlight  height=24 align="center"><s:property value="#listUsers.name"/></TD>
    <TD class=forumrowhighlight height=24 align="center"><s:property value="#listUsers.sex"/></TD>
    
    <TD class=forumrowhighlight height=24 align="center"><s:property value="#listUsers.phone"/></TD>
    <TD class=forumrowhighlight  height=24 align="center"><s:property value="#listUsers.address"/></TD>

    
  <TD class=forumrowhighlight height=24 align="center">
  <s:a href="UserAction!deleteUser.action?user.userId=%{#listUsers.userId}" onclick="return confirm('您确定要删除本用户吗?')">删除</s:a></TD>
    <TD class=forumrowhighlight  height=24 align="center"><a href="include/user/userQuery.jsp">查询</a></TD>
  </TR>
  </s:iterator></s:else>
  
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
