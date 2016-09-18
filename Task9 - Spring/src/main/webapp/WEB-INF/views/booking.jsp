<%--
  Created by IntelliJ IDEA.
  User: Gambit
  Date: 9/19/2016
  Time: 12:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Booking page</title>
</head>
<body>
    <h2>Hi, ${username}!!</h2>
    <form name='bookingForm' action="/book" method='POST'>


        <c:if test="${not empty message}">
            <c:out value="${message}"/>
        </c:if>
        <table>
            <tr>
                <td>Movie:</td>
                <td><input type='text' name='movie' value=''></td>
            </tr>
            <tr>
                <td>Date:</td>
                <td><input type='text' name='date' /></td>
            </tr>
            <tr>
                <td>Time:</td>
                <td><input type='text' name='time' /></td>
            </tr>
            <tr>
                <td>Seat:</td>
                <td><input type='text' name='seat' /></td>
            </tr>
            <tr>
                <td>Amount:</td>
                <td><input type='text' name='amount' /></td>
            </tr>

            <tr>
                <td colspan='2'><input name="submit" type="submit"
                                       value="submit" /></td>
            </tr>
        </table>

        

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
</body>
</html>
