
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .title{
           text-align: center;
            font-size: 25px;
            margin-top: 50px;
        }
        .body{
            background-color: antiquewhite;
            width: 400px;
            height: 225px;
            margin:50px auto;
            border: 2px solid #cccccc;
            border-radius: 10px;
            font-size: 20px;
            color: #008c8c;
        }
        .body button{
            width: 50px;
            height: 30px;

            color: #008c8c;
        }
        .body input{
            width: 250px;
            height: 30px;
            margin-left: 22px;
            margin-top: 20px;
            margin-bottom: 20px;
        }
        .body form{
            margin: inherit;
        }

        .body li{
            margin-left: 70px;
        }
    </style>
</head>
<body>
    <div class="title">
        <h2>批量导入</h2>
    </div>
    <div class="body">
        <form action="addUsers.do" method="post" enctype="multipart/form-data">
            <ur>
                <li>
                    请选择文件:<input type="file" required="required" name="excel" value="">
                </li>
                <li>
                    <a href="downloadUserTemplate.do">模板下载</a>
                </li>
                <li><button type="submit">提交</button></li>
            </ur>
        </form>
    </div>
</body>
</html>
