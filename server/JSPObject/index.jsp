<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <body>
    EL + JSTL
    这是一个测试用的JSP资源<br>
    <%
        String value = "zzt";
    %>
    <a href="login?value=<%=value%>">我是一个链接</a>
    <%=value%>
  </body>
</html>
    <%!
        private String message = "zzt";//属性
        public void test(){//方法
            System.out.println("我的名字是"+message);
        }
    %>
