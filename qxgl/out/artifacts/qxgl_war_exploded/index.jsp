<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>登录</title>
  <link rel="stylesheet" href="index.css"/>
  <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body>
  <form action="login.do" method="post">
    <div id="login-box">
      <h1>Login</h1>
      <div class="form">
        <div class="returnMessage">
          ${"-1".equals(flag)?"用户名或密码失败":""}

        </div>
        <div class="item">
          <i class="fa fa-github-alt" style="font-size:24px"></i>
          <input type="text" placeholder="uname" name="uname" required="required">
        </div>
        <div class="item">
          <i class="fa fa-search" style="font-size:24px"></i>
          <input type="password" placeholder="upass" name="upass" required="required">
        </div>
      </div>
      <button type="submit">Login</button>
    </div>
  </form>
</body>
</html>