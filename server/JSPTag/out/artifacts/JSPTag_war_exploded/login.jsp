<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <script type="text/javascript">
            window.onload = function(){
                var registButton = document.getElementById("regist");
                registButton.onclick = function(){
                    window.location.href = "regist.jsp";
                }
            }
        </script>
    </head>
    <body>
        <form action="" method="post">
            账号:<input type="text" name="username" value=""><br>
            密码:<input type="password" name="password" value=""><br>
            <input type="submit" value="登录">
            <input id="regist" type="button" value="注册">
        </form>
    </body>
</html>
