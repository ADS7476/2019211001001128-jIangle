<%--
  Created by IntelliJ IDEA.
  User: 74761
  Date: 2021/4/8
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <form method="post" action="login">
            <h1>Login</h1>
            <%
                if(!(request.getAttribute("message")==null)){
                    out.print("<h3>"+request.getAttribute("message")+"</h3>");
                }
            %>
            username:<input required="required" type="text" name="username" placeholder="name"><br/>
            password:<input required="required" type="password" name="password" placeholder="password" minlength="8"><br/>
            <input required="required" type="submit" value="Login"/>
        </form>
        <%@include file="footer.jsp"%>
    </body>
    </html>
