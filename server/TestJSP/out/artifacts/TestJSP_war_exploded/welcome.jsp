<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <body>
        <%
            //JSP的内置对象  内置对象有9个
            String aname = request.getParameter("aname");
        %>
        ****************************<br>
        欢迎<%=aname%>进入ATM系统<br>
        ****************************<br>
        请输入操作选项<br>
        <a href="inquiry?aname=<%=aname%>">查询</a><br>
        <a href="showDeposit.jsp?aname=<%=aname%>">存款</a><br>
        <a href="">取款</a><br>
        <a href="">转账</a><br>
    </body>
</html>
