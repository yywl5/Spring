<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>星星图书主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/yywl5/css/LoginMainPage.css"/>
    <script src="<c:url value="/static/yywl5/js/jquery-3.6.0.min.js"/>"></script>
    <style type="text/css">

        #box-1{
            width: 200px;
            height: 200px;
            border: 1px solid gray;
            border-radius: 50%;
        }
        #box-1 img{
            width: 100%;
            height: 100%;
            border-radius: 50%;

        }
        dialog::backdrop {
           background:rgba(255,255,10,.2);
            pointer-events: none;
            z-index: 900;
        }

        dialog{
            padding: auto;
            left: 0;
            position: absolute;
            top: 0;
            bottom: 0;
            right: 0;
            margin: auto;
            border-radius: 15px;
            width: 400px;
            height: 400px;
        }
        dialog input{
            box-sizing: border-box;
            text-align:center;
            font-size:0.8em;
            height:2.5em;
            border-radius:6px;
            border:1px solid #c8cccf;
            color:#6a6f77;
            display:block;
            padding:0 1em;
            text-decoration:none;
            width: 100%;

        }
        dialog button{
            border-radius: 15px;
            font-size:0.7em;
            height:1.5em;
            border:1px solid #c8cccf;
            color:#6a6f77;
            display:block;
            width:100%;
            height:10%;
        }

    </style>
</head>

<body>

<header>
    <a href="#" class="logo"> <h2>欢迎 <span>${user.getUserLogin()}</span> 来到星星图书主页</h2></a>
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
    <c:forEach var="fileName" items="${filesFileName}">
        <c:url value="/download4" var="fileUrl">
            <c:param name="fileName" value="${fileName}"/>
        </c:url>
    </c:forEach>
    <div id="box-1">
        <a href="${fileUrl}">${fileName }</a>
        <img id="show-img" src="${fileUrl}" alt=""/>
    </div>
   <li><a href="#" id="update" onclick="updateUserName()">点击修改用户名</a></li>
    <li><a href="#" id="logout" onclick="logoutUser()">点击注销用户</a></li>
    <li><a href="${pageContext.request.contextPath}/toBorrows">借阅信息</a></li>
    <li><a href="${pageContext.request.contextPath}/toBooks">图书信息</a></li>
    <li><a href="${pageContext.request.contextPath}/toAdminNews">新闻后台</a></li>
    <li><a href="#" id="updateuserPassword" onclick="updatePassword()">更改密码</a></li>
    <li><a href="#" id="setHeadImg" onclick="showDialog()">上传头像</a></li>
    <dialog>
        <button id="close" ONCLICK="hideDialog()">&Chi;</button>
        <form action="${pageContext.request.contextPath}/fileUpload" method="post" enctype="multipart/form-data" onsubmit="return check()">
            上传人：<input id="usernames" type="text" name="usernames" value="${user.getUserName()}"readonly=“readonly”/><br />
            请选择文件：<input id="file" type="file" name="uploadfile" multiple="multiple" /><br />
            <input type="submit" value="上传" />
        </form>
    </dialog>
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
    let dialog = document.querySelector("dialog");
    function showDialog() {

        dialog.show();
        dialog.style.zIndex='1001';
        var div=document.createElement("div");//动态创建div盒子
        //div.id="box";//创建id
        //div.style.width=document.body.offsetWidth+"px";//返回div的父元素的x坐标值
        //div.style.height=screen.height+"px";//返回屏幕的高度值
        //div.style.background="#323232";//给div添加背景颜色
        //div.style.opacity="0.2";//改变透明度Confirm
        //div.style.position="absolute";//div绝对定位
        //div.style.top="0";
        //div.style.left="0";
        //div.style.zIndex='1000';//定义文档流之间的层级关系
        //document.body.appendChild(div);//动态创建div添加到document文档显示
    }

    // 隐藏对话框
    function hideDialog() {
        dialog.close();
    }
    //dialog 居中显示

</script>
<script>
    // 判断是否填写上传人并已选择上传文件
    function check() {
        var name = document.getElementById("usernames").value;
        var file = document.getElementById("file").value;
            if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(file)) {
                alert("图片类型必须是.gif,jpeg,jpg,png中的一种")
                return false;
            }
        if (name == "") {
            alert("填写上传人");
            return false;
        }
        if (file.length == 0 || file == "") {
            alert("请选择上传文件");
            return false;
        }
        return true;
    }
</script>
</html>
