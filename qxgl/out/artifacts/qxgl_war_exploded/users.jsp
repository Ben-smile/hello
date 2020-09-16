<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>用户</title>

    <script type="text/javascript">
        function deleteUser(uno) {
            var result = confirm("是否确认删除")
            if (!result) return ;
            location.href='deleteUser.do?uno='+uno;
        }

        function selectUser(uno) {
            location.href='selectUser.do?uno='+uno;
        }

        window.onload = function () {

            //全选按钮
            var inputs = document.getElementsByTagName("input");
            for (var i = 0;i<inputs.length;i++){
                var input = inputs[i];
                if (input.type == 'checkbox'){
                    input.onclick = function () {
                        var f = this.checked;
                        for (var j = 0;j<inputs.length;j++ ){
                            if (inputs[j].type == 'checkbox')
                                inputs[j].checked = f;
                        }
                    }
                    break;
                }
            }

            //增加 一个鼠标移动变色的效果
            var body = document.getElementById("body");
            var trs = body.getElementsByTagName("tr");
            for (var i = 0;i<trs.length;i++){
                var oldColor = trs[i].style.backgroundColor;
                trs[i].onmouseover = function () {
                    this.style.backgroundColor="#d5dad6";
                    this.onmouseleave = function () {
                        this.style.backgroundColor = oldColor;
                    }
                }
                // trs[i].onclick = function(){
                //     var input = this.getElementsByTagName('input')[0] ;
                //     input.checked = !input.checked ;
                // }
            }

            //点击行 勾选
            for (var i = 0;i<trs.length;i++){
                var tr = trs[i];
                tr.onclick = function () {
                    var input = this.getElementsByTagName("input");
                    var f = input[0].checked;
                    input[0].checked = !f;
                }
                //阻止冒泡
                var input = tr.getElementsByTagName("input")[0];
                input.onclick = function (ev) {
                    ev.stopPropagation();
                }
            }
        }

        function deleteUsers() {
            var body = document.getElementById('body');
            var inputs = body.getElementsByTagName('input');
            var unos = '';
            for (var i = 0;i<inputs.length;i++){
                var input = inputs[i];
                if (input.checked){
                    var uno = input.parentNode.nextElementSibling.innerHTML;
                    unos += uno +',';
                }
            }
            console.log(unos);
            location.href = "deleteUsers.do?uno="+unos;
        }
    </script>

    <style>
        #userBox{
            border: 2px solid #008c8c;
            font-size: 25px;
            color: #008c8c;
            margin: auto;
            text-align: center;
        }

        .create{
            font-size: 25px;
            margin-bottom: 20px;
            text-align: center;
        }
        h2{
            text-align: center;
            font-size: 40px;
            padding-top: 50px;
        }

    </style>
</head>
<body>
    <h2>用户列表</h2>
    <div class="create">
        <a href="insert.jsp" >新建用户</a>
        <a href="javascript:deleteUsers()">批量删除</a>
        <a href="createUsers.jsp">批量导入</a>
    </div>
    <table id="userBox" align="center" border="1" cellpadding="2" cellspacing="0">
        <tr>
            <th><input type="checkbox"></th>
            <th>用户编号</th>
            <th>用户姓名</th>
            <th>用户密码</th>
            <th>真实姓名</th>
            <th>用户年龄</th>
            <th>用户性别</th>
            <th>用户电话</th>
            <th>操作</th>
        </tr>
        <tbody id="body">
            <c:forEach items="${requestScope.users}" var="user">

                <tr>
                    <td><input type="checkbox"></td>
                    <td>${user.uno}</td>
                    <td>${user.uname}</td>
                    <td>${user.upass}</td>
                    <td>${user.truename}</td>
                    <td>${user.age}</td>
                    <td>${user.sex}</td>
                    <td>${user.phone}</td>
                    <td>
                        <a href="javascript:selectUser(${user.uno})">编辑</a>&nbsp|
                        <a href="javascript:deleteUser(${user.uno})" >注销</a>|
                        <a href="assignedRoles.jsp?uno=${user.uno}&truename=${user.truename}" >分配角色</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
