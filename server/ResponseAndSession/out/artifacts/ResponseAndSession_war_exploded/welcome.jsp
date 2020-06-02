<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <%
//            response.setCharacterEncoding("UTF-8");
//            response.getWriter();

            //String s = null;
            //s.length();//空指针异常
            //int statusNumber = response.getStatus();//获取状态响应码
            //System.out.println(statusNumber);//200
            //response.setStatus(500);

            String name = request.getParameter("name");
            String password = request.getParameter("password");
        %>
        我是welcome.jsp<br>
        <%=name%><br>
        <%=password%>
    </body>
</html>
