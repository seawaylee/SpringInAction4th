<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RegisterForm</title>
</head>
<body>
<h1>Login</h1>
<%--这里Form表单没有设置action,因此他会将请求提交到与展现时相同的URL路径上--%>
<form method="post" action="" >
    Username:<input type="text" name="username"/><br/>
    Password:<input type="password" name="password"/><br/>
    RememberMe:<input name="remember-me" type="checkbox"/>
    <input type="submit" value="Login"/>
</form>

</body>
</html>