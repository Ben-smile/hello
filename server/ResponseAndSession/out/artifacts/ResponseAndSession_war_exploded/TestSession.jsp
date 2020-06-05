<%@page errorPage="error.jsp" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
    <body>
        <%
            String value = application.getInitParameter("testParam");
            System.out.println("全局信息:"+value);

            String realPath = application.getRealPath("/");
            System.out.println(realPath);

            String str = null;
            str.length();//NullPointerException
        %>
        <form action="TestSessionOne.jsp" mathod="post">
            测试数据:<input type="text" name="test" value=""><br>
            <input type="submit" value="submit">
        </form>
    </body>
</html>
