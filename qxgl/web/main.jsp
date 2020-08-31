<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" href="main.css">

    <style>
        body{
            background-image:url('image/3.jpg');
            background-repeat:no-repeat;
            background-size:100% auto;
            color: #008c8c;
        }

        #top{
            text-align: center;
            height: 15%;
            border: 2px solid gray;
            font-size: 25px;
        }

        #menuBox{

            list-style: none;
            cursor: pointer;
            padding-left: 100px;
            padding-top: 30px;
        }

        #left{
            margin-top: 6px;
            height: 84%;
            width: 25%;
            border: 2px solid gray;
            float: left;
            font-size: 25px;
        }

        #right{
            margin-top: 6px;
            height: 84%;
            width: 74%;
            border:  2px solid gray ;
            float: right;
            font-size: 25px;
        }

        #top span{
            display: block;
            padding-top: 25px;
            font-size: 35px;
        }
    </style>
</head>
<body>
    <div id="top">
        <span>欢迎${sessionScope.loginUser.uname}进入权限管理系统</span>
    </div>
    <div id="left">
        <ul id="menuBox">
            <li>
                <span>权限管理</span>
                <ul>
                    <li><span><a href="userList.do" target="right">用户管理</a></span></li>
                    <li><span>角色管理</span></li>
                    <li><span>菜单管理</span></li>
                </ul>
            </li>
            <li>
                <span>基本信息管理</span>
                <ul>
                    <li><span>商品管理</span></li>
                    <li><span>供应商管理</span></li>
                    <li><span>库房管理</span></li>
                </ul>
            </li>
            <li>
                <span>系统管理</span>
                <ul>
                    <li><span>修改密码</span></li>
                    <li><span>注销</span></li>
                </ul>
            </li>
        </ul>
    </div>
    <div id="right">
        <iframe  name="right" width="100%" height="100%" frameborder="0"></iframe>
    </div>
</body>
</html>
