<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <body>
        <%
            String aname = request.getParameter("aname");//EL+JSTL
        %>
        <form action="deposit" method="post">
            请输入存款金额:<input type="text" name="depoistBalance" value=""><br>
            <input type="submit" value="确定">
            <input type="hidden" name="aname" value="<%=aname%>">
        </form>
    </body>
</html>
