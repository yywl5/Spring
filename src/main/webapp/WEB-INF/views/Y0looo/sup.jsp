<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>辅助界面</title>
        <style>
            body {
                width: 80%;
                margin: 0 auto;
                height: auto;
                text-align: center;
            }
        </style>
    </head>
    <body>

        <c:if test="${!empty(sup)}">
            <h1>提示</h1>
            <h3 style="color: red">${sup}</h3>
            <a href="${pageContext.request.contextPath}/toBooks">返回图书列表</a>
        </c:if>
        <c:if test="${!empty(sup1)}">
            <h1>提示</h1>
            <h3 style="color: red">${sup1}</h3>
            <a href="${pageContext.request.contextPath}/toBorrows">返回借阅列表</a>
        </c:if>
        <c:if test="${!empty(errorMsg)}">
            <h1>错误信息</h1>
            <h3 style="color: red">${errorMsg}</h3>
            <a href="${pageContext.request.contextPath}/toLastPage">返回主页</a>
        </c:if>

    </body>
</html>
