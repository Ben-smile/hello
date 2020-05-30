<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
  <body>
    <form action="regist" method="post">
        姓名:<input type="text" name="name" value=""><br>
        性别:<input type="text" name="sex" value=""><br>
        爱好:
        <input type="checkbox" name="hobby" value="抽烟">抽烟<br>
        <input type="checkbox" name="hobby" value="喝酒">喝酒<br>
        <input type="checkbox" name="hobby" value="烫头">烫头<br>
        <input type="submit" value="提交">
    </form>
      <%
          /*
            StringBuffer url = request.getRequestURL();
            String uri = request.getRequestURI();
            out.print(url);//JSP内置对象out  JSPWriter   浏览器展示
            out.print("<br>");
            out.print(uri);//
            System.out.println(url);//在控制台打印
            System.out.println(uri);
          */
            //String value = request.getHeader("key");
//          Enumeration en = request.getHeaderNames();//获取全部的key

      %>
  </body>
</html>
