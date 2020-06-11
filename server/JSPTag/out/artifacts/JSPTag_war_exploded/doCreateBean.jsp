<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="atm" class="domain.Atm" scope="request"></jsp:useBean>
<jsp:setProperty name="atm" property="aname" param="aname"></jsp:setProperty>
<jsp:setProperty name="atm" property="apassword" param="apassword"></jsp:setProperty>
<jsp:setProperty name="atm" property="abalance" param="abalance"></jsp:setProperty>
<jsp:forward page="doRegist">
    <jsp:param name="testKey1" value="testValue1"></jsp:param>
    <jsp:param name="testKey2" value="testValue2"></jsp:param>
</jsp:forward>


