
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>角色信息</title>
</head>
<body>
    <h2 align="center">角色管理</h2>
    <table align="center" border="0" cellspacing="0" width="80%">
        <tr>
            <td>
                <input id="rno" placeholder="角色编号">
                <input id="rname" placeholder="角色名称">
                <input id="description" placeholder="角色描述">
            </td>
        </tr>
    </table>
    <table align="center" border="1" cellspacing="0" width="80%">
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
        <table align="center" border="0" cellspacing="0" width="80%">
            <tr >
                <td align="left">
                    <select>
                        <option>3</option>
                        <option>5</option>
                        <option>7</option>
                        <option selected="selected">${rows}</option>
                    </select>
                    第${page}页/共${maxPage}页
                </td>
                <td align="right">
                    <a href="">首页</a>
                    <c:if test="${page>1}" >
                        <a href="">上一页</a>
                    </c:if>
                    <c:if test="${page<maxPage}">
                        <a href="">下一页</a>
                    </c:if>
                    <a href="">末页</a>
                </td>

            </tr>
        </table>
    </table>
</body>
</html>
