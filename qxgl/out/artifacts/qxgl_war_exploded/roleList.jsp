
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>角色信息</title>
    <Style>
        input {
            margin-right: 20px;
            height: 30px;
        }
        #button{
            height: 30px;
            width: 60px;
            color: #008c8c;
        }

        #selectBox {
            margin-bottom: 20px;

        }
        #tableBox{
            border: 2px solid #008c8c;
            color: #008c8c;
            font-size: 20px;
        }

        #pageBox{
            margin-top: 10px;
            color: #008c8c;
            font-size: 20px;
        }
        h2 {
            font-size: 40px;
            color: #008c8c;
        }
        #rows{
            height: 25px;
            color: #008c8c;
        }
    </Style>

    <script type="text/javascript">
        //设置一个公用的方法用来查询
        function selectRoles() {
            //查询需要获取的参数
            //1.page 2.rows 3.rno 4.rname 5.description
            var rno = document.getElementById("rno").value;
            var rname = document.getElementById("rname").value;
            var description  = document.getElementById("description").value;
            var page  = document.getElementById("page").value;
            var rows  = document.getElementById("rows").value;

            location.href = "roleList.do?page="+page+"&rows="+rows+"&rno="+rno+"&rname="+rname+"&description="+description;
        }

        //点击改变参数时 设计方法 改变参数 调用通用方法
        function changePage(page) {
            document.getElementById("page").value = page;

            selectRoles();
        }


        window.onload = function () {
            //改变rows
            var rows = document.getElementById("rows");
            rows.onchange = function () {
                selectRoles();
            }

            //模糊查询 添加回车 事件

            var table = document.getElementById("selectBox");
            var inputs = table.getElementsByTagName("input");
            for (var i = 0;i<inputs.length;i++){
                inputs[i].onkeydown = function (ev) {
                    var ev = window.event || ev;
                    if (ev.keyCode === 13){
                        selectRoles();
                    }
                }
            }

            //清空按钮
            var button = document.getElementById("button");
            button.onclick = function () {
                document.getElementById("rno").value = null;
                document.getElementById("rname").value = null;
                document.getElementById("description").value = null;
                selectRoles();
            }


        }

    </script>
</head>
<body>
    <h2 align="center">角色管理</h2>
    <input type="hidden" value="${page}" id="page">
    <table  id="selectBox" align="center" border="0" cellspacing="0" width="80%">
        <tr>
            <td>
                <input id="rno" placeholder="角色编号" value="${rno}">
                <input id="rname" placeholder="角色名称" value="${rname}">
                <input id="description" placeholder="角色描述" value="${description}">
                <button id="button">清空</button>
            </td>
        </tr>
    </table>
    <table id="tableBox" align="center" border="1" cellspacing="0" width="80%">
        <thead>
            <tr>
                <th>角色编号</th>
                <th>角色名称</th>
                <th>角色描述</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.rolesList}" var="role" >
                <tr>
                    <td>${role.rno}</td>
                    <td>${role.rname}</td>
                    <td>${role.description}</td>
                </tr>
            </c:forEach>

        </tbody>
        <table id="pageBox" align="center" border="0" cellspacing="0" width="80%">
            <tr >
                <td align="left">
                    <select id="rows" >
                        <option>3</option>
                        <option>5</option>
                        <option>7</option>
                        <option selected="selected">${rows}</option>
                    </select>
                    第${page}页/共${maxPage}页
                </td>
                <td align="right">
                    <a href="javascript:changePage(1)">首页</a>
                    <c:if test="${page>1}" >
                        <a href="javascript:changePage(${page-1})">上一页</a>
                    </c:if>
                    <c:if test="${page<maxPage}">
                        <a href="javascript:changePage(${page+1})">下一页</a>
                    </c:if>
                    <a href="javascript:changePage(${maxPage})">末页</a>
                </td>

            </tr>
        </table>
    </table>
</body>
</html>
