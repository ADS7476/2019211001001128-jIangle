<%--
  Created by IntelliJ IDEA.
  User: 74761
  Date: 2021/4/29
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="textml;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Update</h1>

<%
    User u=(User) session.getAttribute("user");
%>
    <form method="post" action="${pageContext.request.contextPath}/updateUser">
    New Use Registration<br/>
    ID:<input required="required" type="text" name="id" value="<%=u.getId()%>" placeholder="id"><br/>
    username:<input required="required" type="text" name="username" value="<%=u.getUsername()%>" placeholder="name"><br/>
    password:<input required="required" type="text" name="password" value="<%=u.getPassword()%>" placeholder="password" minlength="8"><br/>
    Email:<input required="required" type="email" name="email"value="<%=u.getEmail()%>" placeholder="Email"><br/>
    Gender: <input required="required" type="radio" name="sex" value="male"<%="male".equals(u.getSex())?"checked":""%>>Male
    <input required="required" type="radio" name="sex" value="female"<%="female".equals(u.getSex())?"checked":""%>>Female<br/>
    Date of Birth:<input required="required" type="text" name="birthday"value="<%=u.getBirthday()%>" placeholder="Date of Birth (yyyy-mm-dd)" pattern="\d\d\d\d-\d\d-\d\d"><br/>
    <input required="required" type="submit" value="Save Changes"/>

</form>
<%@include file="footer.jsp"%>
