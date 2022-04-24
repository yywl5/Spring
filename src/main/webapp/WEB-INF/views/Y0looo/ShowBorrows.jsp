<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>借阅表</title>
    </head>
    <body>
        <h3>借阅信息</h3>
        <table>
            <thead>
                <td colspan="2" style="text-align: center">借阅编号</td>
                <td colspan="2" style="text-align: center">图书名称</td>
                <td colspan="2" style="text-align: center">借阅日期</td>
                <td colspan="2" style="text-align: center">归还期限</td>
                <td colspan="2" style="text-align: center">归还日期</td>

                <td colspan="2" style="text-align: center">操作</td>
            </thead>
            <c:if test="${!empty(borrow)}">
                <c:forEach var="borrow" items="#{borrow}">
                    <tr>
                        <td colspan="2" style="text-align: center">${borrow.getBorrowId()}</td>
                        <td colspan="2" style="text-align: center">${borrow.getBookName()}</td>
                        <td colspan="2" style="text-align: center">${borrow.getBorrowDate()}</td>
                        <td colspan="2" style="text-align: center">${borrow.getTimeLimit()}</td>
                        <td colspan="2" style="text-align: center">${borrow.getReturnDate()}</td>
                        <td colspan="2" style="text-align: center"><a href="${pageContext.request.contextPath}/return?bookId=${book.getBookId()}">归还</a></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </body>
</html>
