<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username} <a href="ShoppingList?action=logout">Logout</a></p>
        
        <form method="POST" action="">
            <h2>List</h2>
            <p>Add item: </p>
            <input type="text" name="item"><input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        
        <form method="POST" action="">
            <ul>
                <c:forEach var="shoppingList" items="${shoppingList}">
                    <input type="radio" name="item" value="${shoppingList}"> ${shoppingList}
                    <br>
                </c:forEach>               
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
