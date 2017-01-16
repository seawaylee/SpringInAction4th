<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/tags/" %>
<%@ page isELIgnored="false" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
</head>
<body>
<h1>Your Profile</h1>
${username}<br/>
${firstName} ${lastName}
Access:<security:accesscontrollist/>
Hello:<security:authentication property="principal.username">



</body>
</html>