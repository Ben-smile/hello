<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <head>
    <meta charset="UTF-8">
  </head>
  <body>
    <%
        String aname = request.getParameter("aname");//内置对象9个  JSP的9大内置对象
    %>
    ****************************<br>
    欢迎<%=aname%>进入ATM系统<br>
    ****************************<br>
    请输入操作选项<br>
    <a href="inquiry?aname=<%=aname%>">查询</a><br>
    <a href=deposit?aname=<%=aname%>">存款</a><br>
    <a href="">取款</a><br>
    <a href="">转账</a><br>
  </body>
</html>
