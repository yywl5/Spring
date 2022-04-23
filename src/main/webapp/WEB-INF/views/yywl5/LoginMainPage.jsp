<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>星星图书主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/yywl5/css/LoginMainPage.css"/>
    <script src="<c:url value="/static/potatob6/js/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<div class="container">
    <h2>欢迎 <span>${user.getUserName()}</span> 来到星星图书主页</h2>
    <a href="#" id="update" onclick="updateUserName()">点击修改用户名</a>
    <a href="#" id="logout" onclick="logoutUser()">点击注销用户</a>
</div>

<script src="${pageContext.request.contextPath}/static/yywl5/js/LoginMainPage.js"></script>
</body>
</html>
