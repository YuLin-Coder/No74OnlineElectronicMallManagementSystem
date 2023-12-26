 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="js/style.css" />

<style>
.main_iframe {
	Z-INDEX: 1; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 92%
	</style>
<script type="text/javascript" src="js/boxOver.js"></script>
 </head>
 
<body>

<div id="main_container">
  <div class="top_bar"></div>
	<div id="header">

	 <div id="divstr"><br/><h2>欢迎来到网上商城</h2><h3><script language=JavaScript >
var today = new Date();
var strDate = ( today.getYear() + "年" + (today.getMonth() + 1) + "月" + today.getDate() + "日");

var n_day = today.getDay();
var ww;

switch (n_day)
{
case 0:{ww =  "星期日";} break;
case 1:{ww =  "星期一";} break;
case 2:{ww =  "星期二";} break;
case 3:{ww =  "星期三";} break;
case 4:{ww =  "星期四";} break;
case 5:{ww =  "星期五";} break;
case 6:{ww =  "星期六";} break;
case 7:{ww =  "星期日";} break;
}
strDate="今天是:" + ww+"</font>";
document.write(strDate);
 </script></h3></div>
	  <!-- end of oferte_content-->
</div>
    
   <div id="main_content"> 
            <div id="menu_tab">
            <div class="left_menu_corner"></div>
                    <ul class="menu">
                         <li><a href="GoIndexAction.action" class="nav1">首页</a></li>
                         <li class="divider"></li>
                         <li><a href="GoIndexAction.action" class="nav2">在线购物</a></li>
                         <li class="divider"></li>
                         <li><a href="showCar.jsp" class="nav5">我的购物车</a></li>
                         <li class="divider"></li>
                         
                         <c:if test="${empty sessionScope.user.username}">
                         <li class="divider"></li>
                         <li><a href="login.jsp" class="nav3">用户登录</a></li>
                         <li class="divider"></li>                         
                         <li><a href="register.jsp" class="nav6">用户注册 </a></li>

                         </c:if>
                         <li class="divider"></li>
                    </ul>

             <div class="right_menu_corner"></div>
            </div><!-- end of menu tab -->
    
    </div> 
    
    <div class="crumb_navigation">
    导航:  <span class="current"><a href="GoIndexAction.action">首页</a>&gt;&gt;${searchClassMessage} </span>
    
    </div>
    <div align="right"><form name="searchform" action="CommodityAction!findCommodityByName.action" method="post">
    <input id="commodity.commodityName" name="commodity.commodityName" style="font-size: 10pt; color: rgb(85, 85, 85);" onfocus="if(this.value=='请输入您所要查找的商品名称'){this.value='';}" onblur="if(this.value==''){this.value='请输入您所要查找的商品名称';}" value="请输入您所要查找的商品名称" size="25" maxlength="30" type="text" />
<input name="搜索" type="submit" value="搜索" />
    </form></div>
          
    <table width=100%  align="center"><tr>
	<td class="left_content" valign="top">
    <table>
    <tr>
    <td class="title_box">商品分类</td></tr>
    <tr><td>
    <ul class="left_menu">
    <s:iterator value="#request.listCommodityClasses"  status="stu" id="classes">
        	<s:if test="#stu.odd==true">
        		<li class="odd">
        			<s:a href="CommodityAction!findCommodityByClass.action?commodityClassId=%{#classes.commodityClassId} ">
        				<s:property value="#classes.commodityClassName"/>
        			</s:a>
        		</li>
        	</s:if>
        	<s:else>
        		<li class="even">
        			<s:a href="CommodityAction!findCommodityByClass.action?commodityClassId=%{#classes.commodityClassId} ">
        				<s:property value="#classes.commodityClassName"/>
        			</s:a>
        		</li>
        	</s:else>	
        </s:iterator></ul><br/></td>
     </tr>
          
    </table>
    </td>
    
    <td valign="top" align="left"> 
     <div class="center_content">
   	<div class="center_title_bar" >${searchClassMessage }</div>
   	<s:if test="#request.commodityByClass.isEmpty" >
   	<div ><h3>对不起，此类商品暂时为空！</h3>
   	</div>
   	</s:if><s:else>
   	    	<s:iterator value="#request.commodityByClass" var="commodityByClass">
    		<div class="prod_box">
	        	<div class="top_prod_box"></div>
	            <div class="center_prod_box">            
	                 <div class="product_title"><s:a href="CommodityAction!findCommodityById.action?commodity.commodityId=%{#commodityByClass.commodityId}"><s:property value="#commodityByClass.commodityName" /></s:a></div>
	                 <div class="product_img"><s:a href="CommodityAction!findCommodityById.action?commodity.commodityId=%{#commodityByClass.commodityId}"><img src="product/<s:property value='#commodityByClass.image' />" 
	                 alt="<s:property value='#commodityByClass.commodityName' />" title="<s:property value='#commodityByClass.commodityName' />" border="0"  width="144px" height="144px"/></s:a></div>
	                 <div class="prod_price"><span class="reduce">￥<s:property value="#commodityByClass.commodityPrice"/></span> <span class="price">￥<s:property value="#commodityByClass.webPrice"/></span></div>                        
	            </div>
	            <div class="bottom_prod_box"></div>             
	            <div class="prod_details_tab">
	            <a href="AddToCarAction?commodity.commodityId=<s:property value='#commodityByClass.commodityId'/>" title="header=[添加到购物车] body=[&nbsp;] fade=[on]"><img src="images/cart.gif" alt="" title="" border="0" class="left_bt" /> </a>      
	           <a href="CommodityAction!findCommodityById.action?commodity.commodityId=<s:property value='#commodityByClass.commodityId'/>" class="prod_details">详细</a> </div>                     
	        </div>
	        </s:iterator></s:else>
    	</div>
     </td>
     
     
   <td class="right_content"></td>
     </tr>
    </table>
    
  
 
  <div class="footer" align="center"><br />&copy;&nbsp;&nbsp;|&nbsp;XXXX&nbsp;|&nbsp;版权所有&nbsp;|&nbsp;网上商城系统<br/><a href="admin/login.jsp">后台管理</a></div>
</div>

</body>
</html>

