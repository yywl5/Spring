<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <table>
            <c:if test="${!empty(news)}">
                <tr>
                    <td>标题：</td><td>${news.getNtitle()}</td>
                </tr>
                <tr>
                    <td>作者：</td><td>${news.getNeditor()}</td>
                </tr>
                <tr>
                    <td>发布者：</td><td>${news.getNpublisher()}</td>
                </tr>
                <tr>
                    <td>时间：</td><td>${news.getNcreateTime()}</td>
                </tr>
                <tr>
                    <td>内容：</td><td>${news.getNcontent()}</td>
                </tr>
            </c:if>
            <c:if test="${!empty(list)}">
                <c:forEach var="list" items="${list}">
                    <tr>
                        <td>
                            <a href="${pageContext.request.contextPath}/showNewsDetail?newsId=${list.getNno()}" title="${list.getNtitle()}" target="showNews">${list.getNtitle()}</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </body>
</html>
