<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form method="POST" action="ShoppingList">
            <label>Username: </label>
            <input type="text" name="usernameInput" value="${username}">
            <input type="submit" value="Register name">
        </form>
<!--            <p>${logoutMessage}</p>-->
    </body>
</html>
