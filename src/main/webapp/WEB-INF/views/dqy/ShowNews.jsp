<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <table>
            <c:if test="${!empty(news)}">
                <thead>
                    <td style="text-align: center;font-weight: bolder" colspan="3"><h2>${news.getNtitle()}</h2></td>
                </thead>
                <tr>
                    <td style="text-align: center">作者：${news.getNeditor()}</td><td style="text-align: center">发布者：${news.getNpublisher()}</td><td style="text-align: center">时间：${news.getNcreateTime()}</td>
                </tr>
                <tr>
                </tr>
                <tr>
                    <td style="text-align: left;text-indent: 2em" colspan="3">${news.getNcontent()}</td>
                </tr>
            </c:if>
            <c:if test="${!empty(list)}">
                <c:forEach var="list" items="${list}">
                    <tr>
                        <td>
                            <a style="text-decoration: none" href="${pageContext.request.contextPath}/showNewsDetail?newsId=${list.getNno()}" title="${list.getNtitle()}" target="showNews">${list.getNtitle()}</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </body>
</html>
