<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!--引入标签库-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <title>审核</title>
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
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }

        #items {
            width: 100%;
            margin: 50px;
            margin-left: 0;
            min-width: 700px;
            flex-shrink: 1;
            backdrop-filter: blur(1.5rem);
            -webkit-backdrop-filter: blur(1.5rem);
            border: 1px solid #dbe2ef;
            border-radius: 10px;
            box-shadow: 0 0 18px rgba(70,70,70,0.2);
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

        #avatar {
            width: 100px;
            height: 100px;
            border-radius: 50px;
        }

        hr {
            width: 60%;
            height: 4px;
            background-color: rgba(70,70,70,0.3);
            border-radius: 2px;
            border: none;
            margin: 40px 0;
        }

        p {
            margin: 20px 0;
        }

        img:hover {
            cursor: pointer;
        }

        #items_top {
            margin: 20px 0;
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: flex-start;
        }

        tr, tbody {
            width: 100%;
        }

        td, th {
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
        }
    </style>
</head>

<body>
<div id="selfCenter">
    <img width="100" id="avatar" height="100" src="${pageContext.request.contextPath}/${admin.avatarPath}" />
    <hr>
    <p>欢迎，${admin.adminName}</p>
    <p>管理员编号:${admin.adminId}</p>
    <p>图书管理后台系统</p>
    <hr>
</div>
<div id="items">
    <div id="items_top">
        <div style="width: 20px; flex-shrink: 0"></div>
        <img onclick="window.location.href=${pageContext.request.contextPath}/Admin/" style="width: 22px; height: 22px; flex-shrink: 0" src="${pageContext.request.contextPath}/static/potatob6/svg/return.svg" />
        <p style="flex-shrink: 1; margin: 0;margin-left: 20px;width: 100%;text-align: center">待办清单</p>
        <div style="width: 20px; flex-shrink: 0"></div>
    </div>

    <div style="width: 100%;">
        <table>
            <tr>
                <th>审核序号</th>
                <th>类型</th>
                <th>申请的用户</th>
                <th>创建时间</th>
                <th>处理状态</th>
                <th>附加信息</th>
            </tr>

            <c:forEach var="item" items="${list}">
                <tr>
                    <td>${item.examId}</td>
                    <td>${item.examType}</td>
                    <td>${item.examUser.userName}</td>
                    <td>${item.examCreateTime}</td>
                    <td>${item.examHandleStatus}</td>
                    <td>${item.examComment}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>