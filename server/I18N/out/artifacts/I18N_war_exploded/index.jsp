<%@ page import="java.util.Properties" %>
<%@ page import="java.io.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <body>
    <%
        //Java项目---不需要Tomcat这种WEB服务器(容器)支持的
        //JavaWEB项目--->需要Tomcat支持---->我们自己的项目部署在Tomcat中
        //  执行的最终项目是经过部署编译后的那些程序
        //  Tomcat中的webapps文件夹下
        //  当前工程的out文件夹下artifacts文件夹下

        //JSP编译----index.jsp      index_jsp.java
        //InputStream inputStream = this.getClass().getResourceAsStream("font(zh-CN).properties");

        //1.可以使用ClassLodaer
        //  将我们的文件放置在src文件夹下
        //  Thread获取当前线程   获取ContextClassLoader对象
        //  直接写名字

        String acceptLanguage = request.getHeader("Accept-Language");
        String[] languages = acceptLanguage.split(",");
        String language = languages[0].split(";")[0];//解析浏览器现在默认支持的第一个语言

        String fileName = "font("+language+").properties";
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        InputStreamReader reader = new InputStreamReader(inputStream);
        //读取当前工程内的一个font.properties文件
        Properties pro = new Properties();
        pro.load(reader);

        String account = pro.getProperty("account");
        String password = pro.getProperty("password");
        String login = pro.getProperty("login");
    %>
    <form action="login" method="post">
      <%=account%>:<input type="text" name="" value=""><br>
      <%=password%>:<input type="password" name="" value=""><br>
      <input type="submit" value="<%=login%>">
    </form>
  </body>
</html>
