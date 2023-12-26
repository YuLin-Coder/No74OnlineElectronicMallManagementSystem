<%@ tag pageEncoding="utf-8" %>
<%@ tag import="java.sql.*" %>
<%@ attribute name="dataSource" required="true" %>
<%@ attribute name="tableName" required="true" %>
<%@ attribute name="user" required="true" %>
<%@ attribute name="pass" required="true" %>
<%@ variable name-given="biao" scope="AT_END" %>
<%@ variable name-given="queryResult" scope="AT_END" %>
<%
   StringBuffer result;
   result=new StringBuffer();
   try{ Class.forName("com.mysql.jdbc.Driver");}
   catch(Exception e){}
   Connection con;
   Statement sql;
   ResultSet rs;
   try{ //result.append("<table border=0>");
        String uri="jdbc:mysql://localhost:3306/"+dataSource+"?useUnicode=true&characterEncoding=utf-8";
        con=DriverManager.getConnection(uri,user,pass);
        DatabaseMetaData metadata=con.getMetaData();
        ResultSet rs1=metadata.getColumns(null,null,tableName,null);
        int 字段个数=0;
        //result.append("<tr>");
        while(rs1.next())
        { 字段个数++;
          String clumnName=rs1.getString(4);
         }
        // result.append("<td width=80>留言用户</td><td width=80>留言标题</td>"+
        // "<td width=80>留言时间</td><td width=80>留言内容</td>");
        //result.append("</tr>");
        sql=con.createStatement();
        rs=sql.executeQuery("select * from "+tableName);
     while(rs.next())
        { 
           int k=2;
         // for(k=2;k<字段个数;k++)
          //{ result.append("<td>"+rs.getString(k)+"</td>");
         // }
         result.append("<table border=0 width=585px> <tr><td rowspan=5 width=50px>留言客户<br/>"+rs.getString(k)+"</td>");k++;
         result.append("<td align=left>留言标题："+rs.getString(k)+"</td>");k++;
         result.append("<td align=right>留言时间："+rs.getString(k)+"</td></tr>");k++;
         result.append("<tr><td rowspan=4 colspan=2 width=500 align=left width=100px><hr/><textarea cols=60 rows=4 readonly wrap=physical width>"+rs.getString(k)+"</textarea></td></tr><hr/></table>");k++;
        }
        //result.append("</table>");
        con.close();
   }
   catch(SQLException e){ out.print(e);}
   jspContext.setAttribute("queryResult",new String(result));
   jspContext.setAttribute("biao",tableName);
%>