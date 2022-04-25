<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>图书列表</title>
    </head>
    <body>
        <h3>图书信息</h3>
        <table>
            <thead>
            <td colspan="2" style="text-align: center">图书编号</td>
            <td colspan="2" style="text-align: center">图书名称</td>
            <td colspan="2" style="text-align: center">图书作者</td>
            <td colspan="2" style="text-align: center">出版社</td>
            <td colspan="2" style="text-align: center">库存</td>
            <td colspan="2" style="text-align: center">价格</td>
            <td colspan="2" style="text-align: center">操作</td>
            </thead>
            <c:if test="${!empty(books)}">
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td colspan="2" style="text-align: center">${book.getBookId()}</td>
                        <td colspan="2" style="text-align: center">${book.getBookName()}</td>
                        <td colspan="2" style="text-align: center">${book.getAuthor()}</td>
                        <td colspan="2" style="text-align: center">${book.getPublisher()}</td>
                        <td colspan="2" style="text-align: center">${book.getStorageCount()}</td>
                        <td colspan="2" style="text-align: center">${book.getPrice()}</td>
                        <td colspan="2" style="text-align: center"><a href="${pageContext.request.contextPath}/borrow?bookId=${book.getBookId()}">借阅</a></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </body>
</html>
