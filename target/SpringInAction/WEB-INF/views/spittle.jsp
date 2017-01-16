<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
</head>
<body>
<h1>Spittles</h1>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Message</td>
        <td>Time</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${spittleList}" var="spittle">
        <tr>
            <td>${spittle.id}</td>~
            <td>${spittle.message}</td>
            <td>${spittle.time}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<span><a href="${pageContext.request.contextPath}/home/spittles/1">首页</a></span>
<span><a href="${pageContext.request.contextPath}/home/spittles/<c:out value='${page-1}'/>"
        <c:if test="${page <= 1}">
            hidden="hidden"
        </c:if>
>上一页</a></span>
<span>当前页:${page}</span>
<span><a href="${pageContext.request.contextPath}/home/spittles/<c:out value='${page+1}'/>"
        <c:if test="${page >= totalPage}">
            hidden="hidden"
        </c:if>
>下一页</a></span>

<span><a href="${pageContext.request.contextPath}/home/spittles/${totalPage}">尾页</a></span>
</body>
</html>