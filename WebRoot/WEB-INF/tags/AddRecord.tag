<%@ tag pageEncoding="utf-8" %>
<%@ tag import="java.sql.*" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="title" required="true" %>
<%@ attribute name="time" required="true" %>
<%@ attribute name="message" required="true" %>
<% Connection con;
   Statement sql;
   ResultSet rs;
   try{ Class.forName("com.mysql.jdbc.Driver");}
   catch(Exception e){ out.println(e);}
   try{ con=DriverManager.getConnection("jdbc:mysql://localhost:3306/no74_webshopping?useUnicode=true&characterEncoding=utf-8","root","123456");
        sql=con.createStatement();
        sql.executeUpdate("insert message (username,messagetitle,messagetime,messagetext) values"
    +"("+"'"+name+"','"+title+"','"+time+"','"+message+"'"+")");
    con.close();
    }
   catch(Exception e){ out.println(e);}
%>