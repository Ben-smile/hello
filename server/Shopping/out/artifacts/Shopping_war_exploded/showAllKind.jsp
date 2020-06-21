<%@ page import="domain.Kind" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <script type="text/javascript">
            window.onload = function(){
                var kindSelect = document.getElementById("kindSelect");
                kindSelect.onchange = function(){
                    //window.alert(this.value);
                    window.location.href = "selectCommodity?kid="+this.value;
                }
            }
        </script>
    </head>
    <body>
        本山寨购物系统有商品种类如下，请下拉选择<br>
        <select id="kindSelect" name="kid">
            <option>==请选择==</option>
            <%
                ArrayList<Kind> kindList = (ArrayList<Kind>)request.getAttribute("kindList");
                for(Kind kind:kindList){
                    out.write("<option value=\""+kind.getKid()+"\">"+kind.getKname()+"</option>");
                }
            %>
        </select>
    </body>
</html>
