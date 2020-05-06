<%--
  Created by IntelliJ IDEA.
  User: krvro
  Date: 05.05.2020
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить пользователя</title>
</head>
<body>

Вы действительно хотите удалить пользователя ${param.id}?

<form action="delete" method="post">
<input type="hidden" name="id" value="${param.id}">

<input type="submit" value="Удалить">
</form>

</body>
</html>
