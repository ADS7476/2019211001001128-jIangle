<%--
  Created by IntelliJ IDEA.
  User: 74761
  Date: 2021/3/24
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jiangleweek3</title>
</head>
<body>
<form method= "post"  action="register">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender: <input type="radio" name="gender">Male <input type="radio" name="gender">Female<br/>
    Date of Birth :<input type="text name=" name="birthDate"><br/>
    <input type="submit" value="Register"/>