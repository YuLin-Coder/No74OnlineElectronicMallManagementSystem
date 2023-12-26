<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>欢迎进入系统后台</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8"><LINK 
href="<%=basePath %>admin/images/syscome.files/Admin.css" rel=stylesheet>
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
<s:form action="CommodityAction!updateCommodity.action" method="post" enctype="multipart/form-data">
<TABLE  width="95%" align=center bgColor=#6ab6b6 border=0>
  <TBODY>
  <TR>
    <TH  height=24>【新增商品】</TH> 
   </TR>
  <TR>
    
  <TD class=forumrowhighlight width="70%"  height=24>
  <s:textfield  name="comnodity.commodityName" value="%{commodity.commodityName}" label="商品名称"></s:textfield></TD></TR>
  <TR>
    
    <TD class=forumrowhighlight   height=24>
      <select name="comnodity.commodityClass" >
      	<option>台式电脑配件</option>
        	<option> 笔记本电脑</option>
         	<option>网络设备</option>
        	<option> 服饰衣物</option>
         	<option>家用电器</option>
      </select>
      </TD>
  </TR>
  <TR>
        <TD class=forumrowhighlight 
      height=24><s:textfield  name="comnodity.manufacturer" label="生产厂家"></s:textfield></TD>
  </TR>
  <TR>
        <TD class=forumrowhighlight 
      height=24><s:file  name="comnodity.Image" label="商品图片："></s:file></TD>
  </TR>
  <TR>
    
    <TD class=forumrowhighlight 
      height=24><s:textarea name="comnodity.commodityDepict" cols="50" rows="5" label="商品描述："></s:textarea></TD>
  </TR>
  <TR>
    
    <TD class=forumrowhighlight 
      height=24><s:textfield type="text" name="comnodity.commodityPrice" label="商品价格："></s:textfield></TD>
  </TR>
  <TR>
   
    <TD class=forumrowhighlight 
      height=24><s:textfield type="text" name="comnodity.webPrice" label="商城价格："></s:textfield></TD>
  </TR>
  <TR>
   
    <TD class=forumrowhighlight 
      height=24><s:textfield type="text" name="comnodity.commodityAmount" label='商品剩余数量：'></s:textfield></TD>
  </TR>
  <TR>
    
    <TD class=forumrowhighlight  height=24><s:submit value="提交"></s:submit>
      <s:submit onclick="javascript:history.back(-1);" value="返回上一页" ></s:submit></TD>
  </TR>
  
  </TBODY></TABLE>
</s:form>  
<BR>
<TABLE class=tableborder cellSpacing=1 cellPadding=3 width="95%" align=center 
border=0>
</TABLE><BR>
</BODY></HTML>
