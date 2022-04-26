<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>星星图书主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/yywl5/css/LoginMainPage.css"/>
    <script src="<c:url value="/static/potatob6/js/jquery-3.6.0.min.js"/>"></script>
</head>
<body>

<header>
    <a href="#" class="logo"> <h2>欢迎 <span>${user.getUserName()}</span> 来到星星图书主页</h2></a>
    <div class="rightSide">
        <div class="btns dayNight">
            <ion-icon name="moon-outline"></ion-icon>
            <ion-icon name="sunny-outline"></ion-icon>
        </div>
        <div class="btns menuToggle">
            <ion-icon name="menu-outline"></ion-icon>
            <ion-icon name="close-outline"></ion-icon>
        </div>
    </div>
</header>
<div class="container">

    <div class="card">
        <div class="imgBx">
            <img src="${pageContext.request.contextPath}/static/yywl5/img/sketch.png" alt="">
        </div>
        <div class="content">
            <h3>Design</h3>
            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Expedita suscipit in modi quibusdam, veritatis assumenda.</p>
            <a href="${pageContext.request.contextPath}/toBooks">借阅图书</a>
        </div>
    </div>
    <div class="card">
        <div class="imgBx">
            <img src="${pageContext.request.contextPath}/static/yywl5/img/money.png" alt="">
        </div>
        <div class="content">
            <h3>Design</h3>
            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Expedita suscipit in modi quibusdam, veritatis assumenda.</p>
            <a href="${pageContext.request.contextPath}/toBorrows">归还图书</a>
        </div>
    </div>
    <div class="card">
        <div class="imgBx">
            <img src="${pageContext.request.contextPath}/static/yywl5/img/startup.png" alt="">
        </div>
        <div class="content">
            <h3>Design</h3>
            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Expedita suscipit in modi quibusdam, veritatis assumenda.</p>
            <a href="#">Read More</a>
        </div>
    </div>
    <div class="card">
        <div class="imgBx">
            <img src="${pageContext.request.contextPath}/static/yywl5/img/data.png" alt="">
        </div>
        <div class="content">
            <h3>Design</h3>
            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Expedita suscipit in modi quibusdam, veritatis assumenda.</p>
            <a href="#">Read More</a>
        </div>
    </div>
</div>
<ul class="navigation">
   <li><a href="#" id="update" onclick="updateUserName()">点击修改用户名</a></li>
    <li><a href="#" id="logout" onclick="logoutUser()">点击注销用户</a></li>
    <li><a href="${pageContext.request.contextPath}/toBorrows">借阅信息</a></li>
    <li><a href="${pageContext.request.contextPath}/toBooks">图书信息</a></li>
    <li><a href="${pageContext.request.contextPath}/toAdminNews">新闻后台</a></li>
</ul>
</body>
<script src="${pageContext.request.contextPath}/static/yywl5/js/LoginMainPage.js"></script>
<script type="module" src="https://cdn.jsdelivr.net/npm/ionicons/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://cdn.jsdelivr.net/npm/ionicons/dist/ionicons/ionicons.js"></script>
<script>
    let menuToggle = document.querySelector('.menuToggle')
    let body = document.querySelector('body')
    let navigation = document.querySelector('.navigation')
    menuToggle.onclick = function() {
        menuToggle.classList.toggle('active')
        navigation.classList.toggle('active')
    }
</script>
</html>
