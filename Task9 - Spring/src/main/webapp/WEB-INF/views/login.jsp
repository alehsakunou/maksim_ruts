<%--
  Created by IntelliJ IDEA.
  User: Gambit
  Date: 9/19/2016
  Time: 12:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<div id="login-box">

    <h2>Login page</h2>

    <c:if test="${not empty error}">
        <c:out value="${error}"/>
    </c:if>
    <c:if test="${not empty message}">
        <c:out value="${message}"/>
    </c:if>

    <form name='loginForm' action="/login" method='POST'>

        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' /></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit"
                                       value="submit" /></td>
            </tr>
        </table>

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
</div>
</body>
</html>
