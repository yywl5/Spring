<%--
  Created by IntelliJ IDEA.
  User: 星包客
  Date: 2022/5/2
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/yywl5/css/register.css">
</head>
<body>
<div class="container">

    <div class="tit" style="color:azure">
        注册
    </div>
    <form action="/register" method="POST">
        <input type="text" placeholder="用户名" name="userName">
        <input type="text" placeholder="昵称" name="userLogin">
        <input type="password" placeholder="密码" name="userPassword">
        <input type="submit" value="注册" id="Button" style="text-align: center;" />
    </form>
    <!--<span>没有账号?<a href="#">去注册</a></span>-->
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
</body>
</html>
