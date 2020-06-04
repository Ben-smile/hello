<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String test = request.getParameter("test");

            //作用域   request一次请求 session一次会话
            request.setAttribute("test",test);
            session.setAttribute("test",test);
        %>
        <a href="TestSessionTwo.jsp">存储完毕,点我呀</a>
    </body>
</html>
