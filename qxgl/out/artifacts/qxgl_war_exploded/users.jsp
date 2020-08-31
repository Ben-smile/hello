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
            location.href='selectUser.do?uno'+uno;
        }
    </script>

    <style>
        #userBox{
            border: 2px solid #008c8c;
            font-size: 25px;
            color: #008c8c;
            margin: auto;
        }

        .create{
            padding-top: 25px ;
            padding-bottom: 50px;
            font-size: 25px;
            text-align: center;
            display: block;
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
    <a href="insert.jsp" class="create">新建用户</a>
    <table id="userBox" border="1">
        <tr>
            <th>用户编号</th>
            <th>用户姓名</th>
            <th>用户密码</th>
            <th>真实姓名</th>
            <th>用户年龄</th>
            <th>用户性别</th>
            <th>用户电话</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.users}" var="user">
            <%
                System.out.println();
            %>
            <tr>
                <td>${user.uno}</td>
                <td>${user.uname}</td>
                <td>${user.upass}</td>
                <td>${user.truename}</td>
                <td>${user.age}</td>
                <td>${user.sex}</td>
                <td>${user.phone}</td>
                <td>
                    <a href="javascript:selectUser(${user.uno})">编辑</a>
                    <a href="javascript:deleteUser(${user.uno})" >注销</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
