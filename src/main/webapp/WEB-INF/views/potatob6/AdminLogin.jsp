<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!--引入标签库-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员登录页面</title>
    <script src="${pageContext.request.contextPath}/static/potatob6/js/axios.min.js"></script>
    <style>
        html {
            display: flex;
            width: 100vw;
            height: 100vh;
            justify-content: center;
            align-items: center;
        }
        * {
            padding: 0;
            margin: 0;
        }
        body{
            position: relative;
            width: 100vw;
            height: 100vh;
            display: flex;
            align-items: center;
            max-width: 1269px;
            flex-direction: row;
            background: url("${pageContext.request.contextPath}/static/potatob6/svg/AdminLogin_bg.svg") center center no-repeat;
        }
        #loginContainer {
            position: absolute;
            right: 50px;
            width: 400px;
            top: 50px;
            bottom: 50px;
            backdrop-filter: blur(2rem);
            -webkit-backdrop-filter: blur(2rem);
            border: 1px solid #dbe2ef;
            border-radius: 7px;
            max-height: 600px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            box-shadow: 0 0 30px rgba(70, 70, 70, 0.3);
        }

        input {
            border: none ;
            border-bottom: 2px solid #778DE3;
            height: 30px;
            background: transparent;
            outline: none;
            text-indent: 10px;
        }
        
        .it {
            display: flex;
            flex-direction: row;
            align-items: flex-end;
            justify-content: center;
            width: 70%;
            height: 50px;
        }

        .it > img {
            width: 30px;
            height: 30px;
        }

        button {
            background-color: #3490de;
            width: 120px;
            height: 37px;
            border: none;
            outline: none;
            border-radius: 9px;
            color: white;
            transition: all 0.3s;
        }
        button:hover {
            cursor: pointer;
            background-color: #07689f;
        }
    </style>
</head>
<body>
    <div id="loginContainer">
        <h3>管理员登录</h3>
        <div style="height: 30px;font-weight: lighter"></div>
        <div class="it">
            <img src="${pageContext.request.contextPath}/static/potatob6/svg/AdminAccount.svg" style="transform: scale(0.8);" alt="" width="25" height="25" />
            <input type="text" id="loginName" />
        </div>
        <div style="height: 30px;"></div>
        <div class="it">
            <img src="${pageContext.request.contextPath}/static/potatob6/svg/AdminPassword.svg" alt="" width="30" height="30" />
            <input type="password" id="password" />
        </div>
        <div style="height: 70px;"></div>
        <button onclick="login()">登录</button>
    </div>

    <!-- axios登录 -->
    <script>
        let empty = /^[ ]*$/;
        function login() {
            var loginName = document.getElementById("loginName").value;
            var password  = document.getElementById("password").value;
            if(empty.test(loginName) || empty.test(password)) {
                alert("用户名和密码不能为空");
                return;
            }
            axios({
                method: 'POST',
                url: '${pageContext.request.contextPath}/adminLogin',
                data: {
                    loginName: loginName,
                    password: password
                }
            }).then(response => {
                let resp = JSON.parse(response.data);
                if(resp.status === "error")
                    alert("参数不合法");
                if(resp.status === "Not Found")
                    alert("用户不存在或密码错误");
                if(resp.status === "Founded")
                    document.location.href="${pageContext.request.contextPath}/AdminPage";
            }).catch(err => {
                console.log("登录失败");
            });
        }
    </script>
</body>
</html>