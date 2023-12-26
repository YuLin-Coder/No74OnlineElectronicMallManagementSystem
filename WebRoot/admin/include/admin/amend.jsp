<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>修改管理员密码</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8"><LINK 
href="../../images/syscome.files/Admin.css" rel=stylesheet>
<SCRIPT language=javascript src="../../images/syscome.files/Admin.js"></SCRIPT>

<STYLE type=text/css>.STYLE1 {
	FONT-WEIGHT: bold; COLOR: #0099ff
}
</STYLE>
<script>
function check()
{	
	var newpass=document.getElementById("newpass").value;
	var newrepass=document.getElementById("newrepass").value;
	
	
	if(newpass==null||newpass=='')
	{	alert("新密码不能为空！");
		return false;
	}
	if(newrepass==null||newrepass=='')
	{	alert("确认密码不能为空！");
		return false;
	}
	if(newpass!=newrepass)
	{	alert("两次输入密码不同！");
		return false;
	}
}
</script>
<META content="MSHTML 6.00.2900.5726" name=GENERATOR></HEAD>
<BODY><BR>
<TABLE class=tableborder cellSpacing=1 cellPadding=3 width="95%" align=center 
border=0>
</TABLE><BR>
<form name="myform" method="post" action="AdminAction!updateAdmin.action" onsubmit="return check();">
<TABLE cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 
border=0>
  <TBODY>
  <TR>
    <TH colSpan=9 height=24>【修改登录密码】
    <input type="hidden" name="admin.adminId" value="${sessionScope.admin.adminId}"/>
      <input type="hidden" name="admin.username" value="${sessionScope.admin.username}"/>   
     </TH>  
  </TR>
         
    <TR>
    <TD class=forumrow><div align="right">新密码：</div></TD>
    <TD colspan="8" class=forumrowhighlight><input type="password" name="admin.password" id="newpass"></TD>
  </TR>
  <TR>
    <TD class=forumrow><div align="right">确认密码：</div></TD>
    <TD colspan="8" class=forumrowhighlight><input type="password" name="repassword" id="newrepass"></TD>
  </TR>
  
  <TR>
    <TD class=forumrow>&nbsp;</TD>
    <TD colspan="8" class=forumrowhighlight><input type="submit" name="Submit" value="提交">
      <input type="reset" name="Submit2" value="重置"></TD>
  </TR>
  <TR>
    <TD class=forumrow>&nbsp;</TD>
    <TD colspan="8" class=forumrowhighlight> ${upAdminMessage} </TD>
  </TR>
  </TBODY></TABLE>
</form>  
<BR>
<TABLE class=tableborder cellSpacing=1 cellPadding=3 width="95%" align=center 
border=0>
</TABLE><BR>
</BODY></HTML>
