<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RegisterForm</title>
</head>
<body>
<h1>Register</h1>
<%--这里Form表单没有设置action,因此他会将请求提交到与展现时相同的URL路径上--%>
<form method="post" enctype="multipart/form-data">
    Username:<input type="text" name="username"/><br/>
    Password:<input type="password" name="password"/><br/>
    FirstName:<input type="text" name="firstName"/><br/>
    LastName:<input type="text" name="lastName"/><br/>
    ProfilePic:<input type="file" name="profilePic" accept="image/jpeg,image/png,image/gif"/><br/>
    <input type="submit" value="Register"/>
</form>

使用Spring表单绑定标签
<%--<sf:form method="post" commandName="spitter">--%>
    <%--Username:<sf:input path="username"/><br/>--%>
    <%--Password:<sf:password path="password"/><br/>--%>
    <%--<input type="submit" value="Register">--%>
<%--</sf:form>--%>
</body>
</html>