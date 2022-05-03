<%--
  Created by IntelliJ IDEA.
  User: 星包客
  Date: 2022/4/23
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" charset="UTF-8"/>
    <title>星星管理系统登录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/yywl5/css/Login.css"/>
    <script src="<c:url value="/static/potatob6/js/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<div class="login_container">
    <form action="/login" method="post">
        <h1>用户登录</h1>
        <%--用户名输入框--%>
        <div class="user">
            <i class="iconfont icon-ren"></i>
            <input id="userInput" name="userName" type="text" placeholder="请输入用户名" onchange="handleInputChange()"
                   onfocus="clear_err()" autocomplete="off" value="${userName}"/>
        </div>
        <div class="err_box user_err">${err_user}</div>
        <%--密码输入框--%>
        <div class="password">
            <i class="iconfont icon-24gl-lock2"></i>
            <input id="pwInput" name="userPassword" type="password" placeholder="请输入密码" onchange="handleInputChange()"
                   onfocus="clear_err()"  value="${userPassword}"/>
        </div>
        <div class="err_box pw_err">${err_pw}</div>
        <%--验证码--%>
        <div class="test_container">
            <input id="checkInput" name="check" type="text" class="test" placeholder="验证码" onchange="handleInputChange()"
                   onfocus="clear_err()" autoComplete="off"  value=""/>
            <div class="test_ers">
                <div class="test_er">${check}</div>
                <div class="update" onclick="updateTest()">点击刷新</div>
            </div>
        </div>
        <div class="err_box test_err">${msg}</div>
        <%--提交按钮--%>
        <input type="submit" value="登录" class="submit"/>
        <span>没有账号?<a href="${pageContext.request.contextPath}/toRegister">去注册</a></span>
        <%--其他部分--%>
    </form>
</div>
<script src="${pageContext.request.contextPath}/static/yywl5/js/Login.js"></script>
</body>
</html>
