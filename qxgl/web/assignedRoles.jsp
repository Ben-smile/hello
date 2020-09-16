
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script  src="js/jquery-3.5.1.min.js"></script>
    <script>

        $(function () {
            //发送 请求 获取还未添加的roles
            var uno = $('#uno').val();
            $.post(
                'selectNotAddedRoles.do',
                {uno:uno},
                function (menus) {
                    for (var i=0;i<menus.length;i++){
                        var menu = menus[i];
                        var li = $('<li rno="'+menu.rno+'">'+menu.rname+'</li>');
                        $('#notAddedRoles ul').append(li);

                    }
                    addDblClickToRight();
                },
                'json'
            );

            //发送 请求 获取已经添加的roles
            $.post(
                'selectAddRoles.do',
                {uno:uno},
                function (menus) {
                    for (var i=0;i<menus.length;i++){
                        var menu = menus[i];
                        var li = $('<li rno="'+menu.rno+'">'+menu.rname+'</li>');
                        $('#AddedRoles ul').append(li);

                    }
                    addDblClickToLeft();
                },
                'json'
            );
            //保存
            $('#save').click(function () {
                var uno = $('#uno').val();
                //获取所有 选择区的角色编号 rno
                var lis = $('#addedRoles ul').children('li');
                var rnos = "";
                lis.each(function (i,e) {
                    rnos += $(e).attr('rno')+",";
                });
                $.post(
                    'updateUserAndRole.do',
                    {uno:uno,rnos:rnos},
                    function () {
                        alert("角色分配成功")
                    }
                );
            });
            //添加向右的按钮
            $('#rightBtn').click(function () {
                $('#notAddedRoles ul').children().appendTo($('#addedRoles ul'));
            });
            //添加 向左的按钮
            $('#leftBtn').click(function () {
                $('#AddedRoles ul').children().appendTo($('#notAddedRoles ul'));
            });
        });

        //双击方法 左边-->双击-->右边   右边同理
        function addDblClickToRight() {
            $('#notAddedRoles li').dblclick(function () {
                $(this).off('dblclick').appendTo($('#addedRoles ul'));
                addDblClickToLeft();

            });
        }

        //添加向左的方法
        function addDblClickToLeft() {
            $('#AddedRoles li').dblclick(function () {
                $(this).off('dblclick').appendTo($('#notAddedRoles ul'));
                addDblClickToRight();
            });
        }





    </script>

    <style>
        body{
            font-size: 20px;
            color: #008c8c;
        }
        #box{
            width: 800px;
            height: 350px;
            margin: 30px auto;
            padding-top: 30px;
        }

        #notAddedRoles,#addedRoles{
            width: 300px;
            height: 300px;
            float: left;
            border: 2px solid #008c8c;
            border-radius: 10px;
        }

        #Btn{
            float: left;
            width: 100px;
            height: 300px;

        }
        #rightBtn{
            margin: 80px 20px 100px 28px;
        }
        #leftBtn{
            margin-left: 28px;
        }
        #notAddedRoles{
            margin-left: 27px;
        }
        h2{
            margin-top: 20px;
        }
        #box li{
            list-style: none;
            font-size: 20px;
            margin-bottom: 5px;
            cursor:pointer;

        }
        #btnBox{
            text-align: center;
        }
        #save{
            width: 100px;
            height: 30px;
        }
    </style>
</head>
<body>
    <%--    //创建一个隐藏框 保存参数 uno--%>
    <input  id="uno" type="hidden" value="${param.uno}">
    <h2 align="center">给-${param.truename}-分配菜单</h2>
    <div id="btnBox">
        <button id="save">保存</button>
    </div>
<%--    <span>未选择的角色</span>--%>
<%--    <span>已选择的角色</span>--%>
    <div id="box">

        <div id="notAddedRoles">
            <ul>

            </ul>
        </div>
        <div id="Btn">
            <button type="submit" id="rightBtn">往右</button>
            <button type="submit" id="leftBtn">往左</button>
        </div>
        <div id="addedRoles">
            <ul>

            </ul>
        </div>
    </div>
</body>
</html>
