<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .userAddBox{
            margin: 50px auto;
            width: 500px;
            height: 350px;
            font-size: 25px;
            color: #008c8c;
        }
        .userAddBox li{
            align-items: center;
        }

        .userAddBox input{
            vertical-align: middle;
            width: 200px;
            height: 25px;
            margin-left: 20px;
        }

        .userAddBox span{
            font-size: 25px;
        }
        .userAddBox div{
            margin-bottom: 20px;
        }
        h2{
            margin-top: 20px;
            font-size: 30px;
            color: #008c8c;
        }
        .button button{
            height: 30px;
            width: 100px;
            margin-left: 100px;
            color: #008c8c;
        }
    </style>
</head>
<body>
<h2 align="center">修改信息</h2>
<div class="userAddBox">

    <form action="updateUser.do?" method="post" id="form">

        <ul>
            <li>
                <div>
                    <span>用户名称:</span>
                    <input type="text" name="uname" required="required" value="${requestScope.user.uname}">
                </div>
            </li>
            <li>
                <div>
                    <span>用户密码:</span>
                    <input id="pass" type="password" name="upass" required="required" value="${requestScope.user.upass}">
                </div>
            </li>
            <li>
                <div>
                    <span>确认密码:</span>
                    <input id="repass" type="password" required="required" value="${requestScope.user.upass}">
                </div>
            </li>
            <li>
                <div>
                    <span>真实姓名:</span>
                    <input type="text" name="truename" required="required" value="${requestScope.user.truename}">
                </div>
            </li>
            <li>
                <div>
                    <span>用户年龄:</span>
                    <input type="text" name="age" required="required" value="${requestScope.user.age}">
                </div>
            </li>
            <li>
                <div>
                    <span>用户性别:</span>
                    <input type="text" name="sex" list="sexlist" required="required" value="${requestScope.user.sex}">
                    <datalist id="sexlist">
                        <option>男</option>
                        <option>女</option>
                    </datalist>
                </div>
            </li>
            <li>
                <div>
                    <span>用户电话:</span>
                    <input type="text" name="phone" required="required" value="${requestScope.user.phone}">
                </div>
            </li>
            <input type="hidden" name="uno" value="${user.uno}">
            <div class="button">
                <button type="submit">提交</button>
            </div>
        </ul>
    </form>
</div>
</body>
</html>
