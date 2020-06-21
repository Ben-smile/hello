<%@ page import="domain.Commodity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <style type="text/css">
            td{
                text-align:center;
            }
        </style>
    </head>
    <body>
        <form action="" method="post">
            <table border="1" align="center" width="60%" height="60%">
                <tr>
                    <th></th><th>商品名称</th><th>商品单价</th>
                </tr>
                <%
                    ArrayList<Commodity> commodityList = (ArrayList<Commodity>)request.getAttribute("commodityList");
                    for(Commodity commodity:commodityList){
                        out.write("<tr>");
                        out.write("<td><input type=\"checkbox\" name=\"\" value=\"\"></td>");
                        out.write("<td>"+commodity.getCname()+"</td>");
                        out.write("<td>"+commodity.getCprice()+"</td>");
                        out.write("</tr>");
                    }
                %>
                <tr>
                    <td colspan="3">
                        <input type="button" value="继续购物">
                        &nbsp;&nbsp;||&nbsp;&nbsp;
                        <input type="button" value="结算清单">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
