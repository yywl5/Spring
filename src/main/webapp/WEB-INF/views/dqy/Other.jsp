<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>提示</title>
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
        <h2>提示：</h2>
        <h4>${message}</h4>
        <a href="${pageContext.request.contextPath}/toAdminNews">返回主页</a>
    </body>
</html>
