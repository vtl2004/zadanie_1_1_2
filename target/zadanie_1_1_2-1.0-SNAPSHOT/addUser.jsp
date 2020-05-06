<%--
  Created by IntelliJ IDEA.
  User: krvro
  Date: 05.05.2020
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Добавить нового пользователя</title>
</head>
<body>
<form action = "users" method="post">
    <input  type="text" name="name">
    <input  type="text" name="age">
    <input type="submit" value="Сохранить" >

</form>
</body>
</html>