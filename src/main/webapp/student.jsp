<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chjck
  Date: 05/05/2024
  Time: 9:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Studentseverlet" method="post" enctype="multipart/form-data">
    <input type="text" name="name" placeholder="tên">
    <br>
    <input type="file" name="img">
    <input type="submit" value="add">
</form>
<table border="1">
    <thead>
    <tr>
        <td>id</td>
        <td>stt</td>
        <td>name</td>
        <td>img</td>
        <td>delete</td>
        <td>edit</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${stdList}" var="std" varStatus="index">
        <tr>
            <td>${std.id}</td>
            <td>${index.count}</td>
            <td>${std.name}</td>
            <td><img src="${std.img}"></td>
            <td><a href="/Studentseverlet?ACTION=DELETE&ID=${STD.id}">DELETE</a></td>
            <td><a href="/Studentseverlet?ACTION=EDIT&ID=${STD.id}">EDIT</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
