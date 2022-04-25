<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>辅助界面</title>
    </head>
    <body>
        <h1>提示</h1>
        <c:if test="${!empty(sup)}">
            <h3 style="color: red">${sup}</h3>
            <a href="${pageContext.request.contextPath}/toBooks">返回图书列表</a>
        </c:if>
        <c:if test="${!empty(sup1)}">
            <h3 style="color: red">${sup1}</h3>
            <a href="${pageContext.request.contextPath}/toBorrows">返回借阅列表</a>
        </c:if>
    </body>
</html>
