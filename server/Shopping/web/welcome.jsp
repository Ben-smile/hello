<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <%
            String uname = request.getParameter("uname");
        %>
        尊敬的<%=uname%>用户，您居然登录成功啦？<br>
        欢迎进入山寨购物系统，想买东西么？<br>
        如果想买，请继续点击&gt;&gt;<a href="selectAllKind">进入</a>&lt;&lt;购物系统
    </body>
</html>
