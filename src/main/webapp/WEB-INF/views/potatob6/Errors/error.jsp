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
        }

        body {
            width: 100vw;
            height: 100vh;
            background: url("${pageContext.request.contextPath}/static/potatob6/svg/error.svg") center center no-repeat;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }

        body > * {
            margin: 20px 0;
        }

        h2, h3 {
            letter-spacing: 0.5rem;
        }

        h2 {
            font-size: 2rem;
        }

        h3 {
            font-size: 1rem;
        }
    </style>
</head>

<body>
    <h2>出现严重错误</h2>
    <p style="text-align: center">${message}</p>
</body>
</html>