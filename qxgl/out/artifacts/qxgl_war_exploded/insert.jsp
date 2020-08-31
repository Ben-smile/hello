
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript">
        //判断两次密码是否一致
        window.onload = function () {
            var form = document.getElementById("form")
            form.onsubmit = function () {
                var pass = document.getElementById("pass");
                var repass = document.getElementById("repass");
                if (pass.value===repass.value){
                    return true;
                }else{
                    alert("两次密码不一致");
                    return false;
                }
            }
        }
    </script>

    <style>
        .userAddBox{
            margin: 0 auto;
            width: 500px;
            height: 350px;
            font-size: 25px;
            color: #008c8c;
        }
        .userAddBox li{
            align-items: center;
        }
    </style>
</head>
<body>
    <div class="userAddBox">
        <h2 align="center">创建用户</h2>
        <form action="createUser.do" method="post" id="form">

            <ul>
                <li>
                    <span>用户名称</span>
                    <input type="text" name="uname" required="required">
                </li>
                <li>
                    <span >用户密码</span>
                    <input id="pass" type="password" name="upass" required="required">
                </li>
                <li>
                    <span >确认密码</span>
                    <input id="repass" type="password" required="required">
                </li>
                <li>
                    <span>真实姓名</span>
                    <input type="text" name="truename" required="required">
                </li>
                <li>
                    <span>用户年龄</span>
                    <input type="text" name="age" required="required">
                </li>
                <li>
                    <span>用户性别</span>
                    <input type="text" name="sex" list="sexlist" required="required">
                    <datalist id="sexlist">
                        <option>男</option>
                        <option>女</option>
                    </datalist>
                </li>
                <li>
                    <span>用户电话</span>
                    <input type="text" name="phone" required="required">
                </li>
                <button type="submit">提交</button>
            </ul>
        </form>
    </div>
</body>
</html>
