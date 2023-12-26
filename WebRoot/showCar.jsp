<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="cn.itbaizhan.po.Commodity" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
	
	 <div id="divstr"><br/><h2>欢迎来到网上商城</h2><h3>
<script language=JavaScript >
var today = new Date();
var strDate = ( today.getYear() + "年" + (today.getMonth() + 1) + "月" + today.getDate() + "日");
/*var hh = today.getHours();
if(hh<10) hh = '0' + hh;
var mm = today.getMinutes();
if(mm<10) mm = '0' + mm;
var ss = today.getSeconds();
if(ss<10) ss = '0' + ss;
*/
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
  <script language=JavaScript >
  function date(){
var today = new Date();
var strDate = ( today.getYear() + "-" + (today.getMonth() + 1) + "-" + today.getDate());

 return strDate;
}
 </script>	
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
                         
                         <li class="divider"></li>
                         <c:if test="${empty sessionScope.user.username}">
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
    导航: <span class="current"><a href="GoIndexAction.action">首页</a>&gt;&gt; 购物车</span>
    
    </div><div align="right"><form name="searchform" action="CommodityAction!findCommodityByName.action" method="post">
    <input id="commodity.commodityName" name="commodity.commodityName" style="font-size: 10pt; color: rgb(85, 85, 85);" onfocus="if(this.value=='请输入您所要查找的商品名称'){this.value='';}" onblur="if(this.value==''){this.value='请输入您所要查找的商品名称';}" value="请输入您所要查找的商品名称" size="25" maxlength="30" type="text" />
<input name="搜索" type="submit" value="搜索" />
    </form></div>
    <table border="0" cellpadding="0" cellspacing="0" align="center" width=100% height="400px" bgcolor="#e9e7e7">
    <tr>
    <td width=15%>
    
    </td>
   <c:if test="${!empty sessionScope.user.username}">
    
    <td class="center_content" width=100% height=400px>
    <div class="center_content">
     <div class="center_title_bar">我的购物车</div>
     <div class="prod_box_big">
     	<div class="top_prod_box_big"></div>
	 	<div class="center_prod_box_big"> 
      <table>
   <%
   	  SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
      String tm= matter.format(new Date()); 
 	  Object s=session.getAttribute("list");
 	  SimpleDateFormat mat=new SimpleDateFormat("yyyyMMdd"); 
      String ornum= mat.format(new Date()); 
      int ra=(int)(1000+Math.random()*9000);
      %>

     <s:if test="#session.car.isEmpty" >
			<tr><td colspan="5">购物车里面没有商品！</td></tr>
		</s:if>
		<s:else>
		
		<tr>
			<td width="60">商品编号</td>
			<td width="120">商品名称</td>
			<td width="124">生产厂商</td>
			<td width="60">商品价格</td>
			<td width="119">移除该商品</td>
			
		</tr>
	<s:iterator value="#session.car" id="cars" >
		<tr>
			<td width="147"> ${cars.commodityId}</td>
			<td width="144"> ${cars.commodityName}</td>
			<td width="124"> ${cars.manufacturer}</td>
			<td width="119"> ${cars.webPrice}</td>
			<td width="119"><a href="AddToCarAction!deleteFromCar.action?commodity.commodityId=${cars.commodityId}">移除</a></td>
		</tr></s:iterator>
		</s:else>
		</table>
		<s:if test="#session.car.isEmpty">
		</s:if>
		<s:else>
		<table>
		<tr>
		<td><form action="OrderFormAction!addOrderForm.action" method="post" name="myform" ><table ><tr><td>
		<input type="hidden" name="orderForm.username" value="${sessionScope.user.username}"/>
	  	<input type="hidden" name="orderForm.totalPrice" value="${totalPrice}" />
	  	<input type="hidden" name="orderForm.isPayoff" value="否" />
	  	<input type="hidden" name="orderForm.submitTime" value="<%=tm %>" />
	 	<input type="hidden" name="orderForm.consignmentTime" value=" "/>
	  	<input type="hidden" name="orderForm.isConsignment" value="否" />
	  	<input type="hidden" name="orderForm.orderFormNum" value="<%=ornum %><%=ra %>" /></td>
	  	<td>
	  	买家备注：<input type="text" name="orderForm.remark" value="无"/></td>
	  	<td><input type="submit"  value="提交订单" />
	  	</td>
	  	</tr>
		</table></form></td><td width=140>&nbsp;</td>
		<td ><form action="GoIndexAction"><input type="submit"  value="继续购物" /></form></td>
		</tr>
		</table>
		</s:else>	  	
	  	</div>
	  </div>
	   <div ></div>
     </div>
	</td>
    
    <td class="right_content"><table>
    <tr>
    <td class="shopping_cart"><table>
    <tr><td class="cart_title">购物车  </td>
    </tr>
     <tr><td class="cart_icon">
     <a href="showCar.jsp" title="">
     <img src="images/shoppingcart.png" alt="" title="" width="48" height="48" border="0" /></a>
    </td>
     </tr></table>
     </td></tr>
     <tr><td> <c:if test="${empty sessionScope.user.username}">
     <form action="UserAction!login.action" name="form" method="post" >
   		<div class="title_box">用户登录</div>  
        <div class="border_box">
		<p>用户名：<input id="username" name="user.username" type="text" style="width:110px"/></p>
		<p>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input id="password" name="user.password" type="password"  style="width:110px"/></p>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="提交" type="submit" value="登录" /><input name="重置" type="reset" value="重置" />
        </p>
        <p align="center">&nbsp;&nbsp;&nbsp;[<a href="register.jsp">新用户注册</a>] &nbsp;[<a href="findPass.jsp" >忘记密码</a>]</p>
        
     </div>  </form> </c:if>
     <c:if test="${!empty sessionScope.user.username}">
            <div class="title_box">用户信息</div>  
        <div class="border_box">
         <br/>
		<p>欢迎登陆：${sessionScope.user.username}</p><br/>
		<p> [<a href="OrderFormAction!findOrderFormByUserName.action?orderForm.username=${sessionScope.user.username}">我的订单</a>]&nbsp;&nbsp; [<a href="updatePass.jsp" >修改密码</a>] </p>
		<p> [<a href="userInfo.jsp">个人信息</a>]&nbsp;&nbsp; [<a href="UserAction!logout.action"  onclick="return confirm('确定要退出吗?')" >退出系统</a>] </p>
     </div>
        </c:if> 
      
    </td>
     </tr>
    </table></td> </c:if> 
    <c:if test="${empty sessionScope.user.username}">
    <td class="center_content" width=100% height=400px align=center>
    <table bgcolor="#e9e7e7" >
    <tr><td> <h3>对不起，还未登录，请登录</h3>
    <h3>正在跳转到登录页面，若没有跳转请<a href=login.jsp>点击这里！</a></h3>
	<%response.setHeader("refresh","3;url=login.jsp");%>
    </td></tr></table>
      </td>

    </c:if>
    </tr>
    </table>
  
 
  <div class="footer" align="center"><br />&copy;&nbsp;&nbsp;|&nbsp;XXXX&nbsp;|&nbsp;版权所有&nbsp;|&nbsp;网上商城系统<br/><a href="admin/login.jsp">后台管理</a></div>

</div>

</body>
</html>