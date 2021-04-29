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
            <%
                Cookie [] allCookies=request.getCookies();
                String username="",password="",rememberMeVale="";
                if(allCookies!=null){
                    for(Cookie c:allCookies){
                        if(c.getName().equals("cUsername")){
                            username=c.getValue();
                        }
                        if(c.getName().equals("cPassword")){
                            password=c.getValue();
                        }
                        if(c.getName().equals("cRememberMe")){
                            rememberMeVale=c.getValue();
                        }
                    }
                }

            %>
            Username:<input type="text" name="username" value="<%=username%>"><br/>
            Password:<input type="password" name="password" value="<%=password%>"><br/>
            <input type="checkbox" name="RememberMe" value="1" <%=rememberMeVale.equals("1") ?"checked":""%>checked/>RememberMe<br/>
            <input type="submit" value="submit"/>
        </form>
        <%@include file="footer.jsp"%>
    </body>
    </html>
