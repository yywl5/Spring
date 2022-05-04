<%--
  Created by IntelliJ IDEA.
  User: 星包客
  Date: 2022/5/2
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>注册页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/yywl5/css/register.css">
</head>
<body>
<div class="container">

    <div class="login_container">
        <form action="<c:url value="/toLogin/register"/>" method="post">
            <h1>注册</h1>
            <%--用户名输入框--%>
            <div class="user">
                <i class="iconfont icon-ren"></i>
                <input id="userInput" name="userName" type="text" placeholder="请输入用户名" onchange="handleInputChange()"
                       onfocus="clear_err()" autocomplete="off" value="${userName}"/>
            </div>
            <div class="err_box user_err">${err_user}</div>
            <div class="user">
                <i class="iconfont icon-ren"></i>
                <input id="nicknameInput" name="userLogin" type="text" placeholder="请输入昵称" onchange="handleInputChange()"
                       onfocus="clear_err()" autocomplete="off" value="${userLogin}"/>
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
            <input type="submit" value="注册" class="submit"/>
            <span>拥有账号?<a href="${pageContext.request.contextPath}/toLogining">去登录</a></span>
            <%--其他部分--%>
        </form>
    </div>

</div>
<div class="square">
    <ul>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
<div class="circle">
    <ul>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
<script src="<c:url value="/static/potatob6/js/jquery-3.6.0.min.js"/>"></script>
<script src="${pageContext.request.contextPath}/static/yywl5/js/Register.js"></script>
</body>
</html>
