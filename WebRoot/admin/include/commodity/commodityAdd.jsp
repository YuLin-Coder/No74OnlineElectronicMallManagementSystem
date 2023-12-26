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
<script language=javascript>
function check()
{	var name=document.getElementById("name").value;
	var manufacturer=document.getElementById("manufacturer").value;
	var Image=document.getElementById("Image").value;
	var commodityDepict=document.getElementById("commodityDepict").value;
	var commodityPrice=document.getElementById("commodityPrice").value;
	var webPrice=document.getElementById("webPrice").value;
	var commodityAmount=document.getElementById("commodityAmount").value;
	
		if(name==null||name==''){
		alert("商品名不能为空！");
		return false;
		}
		if(manufacturer==null||manufacturer==''){
		alert("生产厂家不能为空！");
		return false;
		}
		if(Image==null||Image==''){
		alert("商品图片不能为空！");
		return false;
		}
		if(commodityDepict==null||commodityDepict==''){
		alert("商品描述不能为空！");
		return false;
		}
		if(commodityPrice==null||commodityPrice==''){
		alert("商品价格不能为空！");
		return false;
		}
		if(webPrice==null||webPrice==''){
		alert("商城价格不能为空！");
		return false;
		}
		if(commodityAmount==null||commodityAmount==''){
		alert("商品总数量不能为空！");
		return false;
		}
		
}</script>
<script type="text/javascript">
function change(aa)
{
 document.getElementById("commodityLeaveNum").value=aa;
}
</script>

<META content="MSHTML 6.00.2900.5726" name=GENERATOR></HEAD>
<BODY><BR>
<TABLE class=tableborder cellSpacing=1 cellPadding=3 width="95%" align=center 
border=0>
</TABLE><BR>
<form action="CommodityAction!addCommodity.action" method="post" enctype="multipart/form-data" name="myform" onsubmit="return check();">
<TABLE cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 border=0>
  <TBODY>
  <TR>
    <TH colSpan=2 height=24>【新增商品】</TH> 
   </TR>
  <TR>
    <TD class=forumrow width="30%" height=24><div align="right">商品名称：</div></TD>
  <TD class=forumrowhighlight width="70%" 
      height=24><input type="text" name="commodity.commodityName" id="name"></TD></TR>
  <TR>
    <TD class=forumrow height=24><div align="right">商品分类：</div></TD>
    <TD class=forumrowhighlight 
      height=24>
      
      <select name="commodity.commodityClass.commodityClassId">
      <s:iterator value="#request.commodityClasses" status="stuts" id="test">
      <option value="<s:property value='#test.commodityClassId'/>"><s:property value="#test.commodityClassName"/></option>
      </s:iterator>
      </select>
      
      </TD>
  </TR>
  <TR>
    <TD class=forumrow height=24><div align="right">生产厂家：</div></TD>
    <TD class=forumrowhighlight 
      height=24><input type="text" name="commodity.manufacturer" id="manufacturer"/></TD>
  </TR>
  <TR>
    <TD class=forumrow height=24><div align="right">商品图片：</div></TD>
    <TD class=forumrowhighlight 
      height=24><input type="file" name="image" id="Image" />
     </TD>
  </TR>
  <TR>
    <TD class=forumrow height=24><div align="right">商品描述：</div></TD>
    <TD class=forumrowhighlight 
      height=24><textarea name="commodity.commodityDepict" cols="50" rows="5" id="commodityDepict"></textarea></TD>
  </TR>
  <TR>
    <TD class=forumrow height=24><div align="right" >商品价格：</div></TD>
    <TD class=forumrowhighlight  height=24>
    <input type="text" name="commodity.commodityPrice" id="commodityPrice"></TD>
  </TR>
  <TR>
    <TD class=forumrow height=24><div align="right">商城价格：</div></TD>
    <TD class=forumrowhighlight  height=24>
      <input type="text" name="commodity.webPrice" id="webPrice"></TD>
  </TR>
  <TR>
    <TD class=forumrow height=24><div align="right">商品总数量：</div></TD>
    <TD class=forumrowhighlight height=24>
    <input type="text" name="commodity.commodityAmount" id="commodityAmount" onblur="change(this.value)"></TD>
  </TR>
  <TR>
    <TD class=forumrow height=24><div align="right">商品剩余数量：</div></TD>
    <TD class=forumrowhighlight 
      height=24><input type="text" name="commodity.commodityLeaveNum" id="commodityLeaveNum"  readonly="readonly" ></TD>
  </TR>
  <TR>
    <TD class=forumrow height=24>&nbsp;</TD>
    <TD class=forumrowhighlight 
      height=24><input type="submit" value="提交">
      <input type="reset" value="重置"></TD>
  </TR>
  <TR>
    <TD class=forumrow height=24>&nbsp;</TD>
    <TD class=forumrowhighlight 
      height=24>${addComessage}</TD>
  </TR>
  </TBODY></TABLE>
</form>  
<BR>
<TABLE class=tableborder cellSpacing=1 cellPadding=3 width="95%" align=center 
border=0>
</TABLE><BR>
</BODY></HTML>
