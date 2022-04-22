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

        h2, h3 {
            letter-spacing: 0.5rem;
        }

        h2 {
            font-size: 8rem;
        }

        h3 {
            font-size: 6rem;
        }
    </style>
</head>

<body>
    <h2>错误</h2>
    <h3>代码:${code}</h3>
    <h3>${message}</h3>
</body>
</html>