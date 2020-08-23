<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <form action="download" method="post" enctype="multipart/form-data">
          请输入名字:<input type="text" name="username" value=""><br>
          请选择文件:<input type="file" name="testFile" value=""><br>
          <input type="submit" value="确定">
      </form>
  </body>
</html>
