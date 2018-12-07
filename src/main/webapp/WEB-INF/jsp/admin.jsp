<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理界面</title>
</head>
<body>
<table border="1">
    <tr>
        <td>用户id</td>
        <td>用户名</td>
        <td>用户密码</td>
        <td>性别</td>
        <td>邮箱</td>
        <td>电话</td>
        <td>地址</td>
        <td>爱好</td>
    </tr>
    <c:forEach items="${userList}" var="user" varStatus="i">
        <tr>
            <td><c:out value="${user.id}" /></td>
            <td><c:out value="${user.username}"/></td>
            <td><c:out value="${user.password}"/></td>
            <td><c:out value="${user.sex}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.phone}"/></td>
            <td><c:out value="${user.address}"/></td>
            <td><c:out value="${user.hobby}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
