<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!--引入标签库-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
        <title>管理员个人页面</title>
        <style>
            * {
                margin: 0;
                padding: 0;
                font-size: 1.1rem;
            }

            body {
                position: relative;
                width: 100vw;
                height: 100vh;
                background: url("${pageContext.request.contextPath}/static/potatob6/svg/AdminPage_bg.svg") center center no-repeat;
                display: flex;
                flex-direction: row;
                justify-content: center;
                align-content: center;
                overflow: hidden;
            }

            #selfCenter {
                margin: 50px;
                left: 50px;
                top: 50px;
                width: 400px;
                bottom: 50px;
                backdrop-filter: blur(2rem);
                -webkit-backdrop-filter: blur(2rem);
                box-shadow: 0 0 18px rgba(70,70,70,0.2);
                border: 1px solid #dbe2ef;
                border-radius: 10px;
                flex-shrink: 0;
            }

            #items {
                width: 100%;
                margin: 50px;
                margin-left: 0;
                min-width: 800px;
                flex-shrink: 1;
                display: grid;
                grid-template-columns: repeat(4, 1fr);
                grid-template-rows: repeat(auto-fit, 202px);
                grid-gap: 30px;
                justify-items: center;
                align-items: center;
            }

            .item {
                width: 100%;
                height: 200px;
                backdrop-filter: blur(2rem);
                -webkit-backdrop-filter: blur(2rem);
                border: 1px solid #dbe2ef;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                position: relative;
                box-shadow: 0 0 30px rgba(70,70,70,0.2);
                border-radius: 10px;
                transition: all 0.3s;
                flex-shrink: 0;
            }

            .item:hover {
                box-shadow: 0 0 10px rgba(70,70,70,0.2);
                backdrop-filter: blur(0.3rem);
                -webkit-backdrop-filter: blur(0.3rem);
                cursor: pointer;
                transform: scale(1.03);
            }

            img {
                width: auto;
                height: 50%;
            }

            p {
                flex-shrink: 0;
            }

            .corner {
                border-radius: 30px;
                height: 30px;
                width: 30px;
                background-color: #f73859;
                position: absolute;
                right: 0;
                top: 0;
                transform: translate(15px, -15px);
                color: white;
                text-align: center;
                line-height: 30px;
                justify-content: center;
                align-items: center;
            }
        </style>
    </head>

    <body>
        <div id="selfCenter">

        </div>
        <div id="items">
            <div class="item">
                <img src="${pageContext.request.contextPath}/static/potatob6/svg/AdminPage1.svg" />
                <p>查看待办审核</p>
                <c:if test="${n1 != 0}">
                    <div class="corner">${n1}</div>
                </c:if>
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/static/potatob6/svg/AdminPage1.svg" />
                <p>查看所有的审核</p>
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/static/potatob6/svg/AdminPage5.svg" />
                <p>查看所有管理员</p>
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/static/potatob6/svg/AdminPage2.svg" />
                <p>管理用户借阅</p>
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/static/potatob6/svg/AdminPage4.png" />
                <p>管理用户</p>
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/static/potatob6/svg/AdminPage3.svg" />
                <p>设置中心</p>
            </div>
        </div>
    </body>
</html>