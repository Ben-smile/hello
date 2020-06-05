<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String test = request.getParameter("test");

            //设置一下session对象的失效时间
            //session.setMaxInactiveInterval(10);//5秒后session不活跃
            //作用域   request一次请求 session一次会话
            request.setAttribute("test",test);
            session.setAttribute("test",test);
            application.setAttribute("test",test);

        %>
        <a href="TestSessionTwo.jsp">存储完毕,点我呀</a>
    </body>
</html>
