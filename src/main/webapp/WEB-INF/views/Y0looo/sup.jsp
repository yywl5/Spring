<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>辅助界面</title>
    </head>
    <body>
        <h2>提示</h2>
        <h4 style="color: red">${sup}</h4>
        <a href="${pageContext.request.contextPath}/toBorrows">返回借阅信息</a>
    </body>
</html>
