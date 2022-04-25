<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/static/Y0looo/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/static/potatob6/js/jquery-3.6.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/Y0looo/bootstrap-3.4.1-dist/js/bootstrap.min.js" ></script>
        <title>图书列表</title>
        <style type="text/css">
            body {
                width: 80%;
                margin: 0 auto;
                height: auto;
            }

        </style>
    </head>
    <body>
        <div id="nav">
            <nav class="navbar navbar-default" role="navigation" style="background-color:#fff">
                <div class="container-fluid">
                    <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
                        <a class="navbar-brand " href="#"><p class="text-primary">图书管理系统——用户</p></a>
                    </div>
                    <div class="collapse navbar-collapse" id="example-navbar-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="${pageContext.request.contextPath}/toLastPage">返回上一页<span class="glyphicon glyphicon-log-in"></span></a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <h2>图书信息</h2>
        <div>
            <table class="table table-hover">
                <tr>
                    <th>图书编号</th>
                    <th>图书名称</th>
                    <th>图书作者</th>
                    <th>出版社</th>
                    <th>库存</th>
                    <th>价格</th>
                    <th>操作</th>
                </tr>
                <c:if test="${!empty(books)}">
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td>${book.getBookId()}</td>
                            <td>${book.getBookName()}</td>
                            <td>${book.getAuthor()}</td>
                            <td>${book.getPublisher()}</td>
                            <td>${book.getStorageCount()}</td>
                            <td>${book.getPrice()}</td>
                            <td>
                                <button type="button" class="btn btn-primary btn-lg" onclick="window.location.href='${pageContext.request.contextPath}/borrow?bookId=${book.getBookId()}'">借阅</button>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
        </div>
    </body>
</html>
