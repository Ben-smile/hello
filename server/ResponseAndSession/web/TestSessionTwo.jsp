<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
    <body>
        <%
            String requestTest = (String)request.getAttribute("test");
            String sessionTest = (String)session.getAttribute("test");
        %>
        接收到的数据如下:<br>
        <%=requestTest%><br>
        <%=sessionTest%>
    </body>
</html>
