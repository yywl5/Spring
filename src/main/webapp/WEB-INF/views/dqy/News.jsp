<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>新闻详情</title>
        <style>
            .container {
                float: left;
                width: 100%;
            }

            .main  {
                margin: 0 auto;
                display: flex;
                width: 1300px;
                /* padding-top: 10px; */
            }

            #header {
                width: 1300px;
                margin: 0 auto;
            }

            .main_left {
                float: left;
                width: 400px;
                margin-top: 10px;
            }

            .main_center {
                margin: 0 auto;
                width: 400px;
                margin-top: 10px;
            }

            .main_right {
                float: right;
                width: 400px;
                margin-top: 10px;
                margin-left: 10px;
            }

            .news_1 {
                float: left;
                padding: 20px;
                width: 90%;
                border-bottom:5px #A13F0B solid;
                height: 25px;
                line-height: 25px;
                color: #A13F0B;
            }

            .news_1 h3 {
                float: left;
                padding: 0px;
            }

            .news_1 a {
                color: #A13F0B;
            }


            .news_2 h3 {
                float: left;
                padding: 0px;
            }

            .news_2 span {
                float: right;
                padding: 0 5px;
                font-size: 12px;
            }

            .news_2 a {
                color: #41972e;
            }

            .news_list {
                float: left;
                width: 100%;
            }

            .news_list ul {
                float: left;
                width: 100%;
                padding: 15px 0 40px 0;
            }

            .news_list ul li {
                float: left;
                width: 100%;
                border-bottom: 1px #CCCCCC dotted;
                line-height: 30px;
                height: 30px;
            }

            .news_list ul li a {
                float: left;
                font-size: 8px;
                width: 80%;
                text-overflow: ellipsis;
                overflow: hidden;
                white-space: nowrap;
            }

            .news_list ul li span {
                float: right;
                font-size: 8px;
                width: 20%;
            }

            ul {
                list-style: none;
            }

            .news_1  span {
                float: right;
                margin-top: 18px;
            }

            a {
                text-decoration: none;
            }

            #foot {
                margin: 0 auto;
                width: 1300px;
            }
        </style>
    </head>
    <body>
        <div id="header">
            <h1>图书管理系统————新闻频道</h1>
        </div>
        <div class="container">
            <div class="main">
                <div class="main_left">
                    <div class="news_1">
                        <h3>综合新闻</h3>
                        <span><a href="${pageContext.request.contextPath}/showAllNewsByTypeId?TypeId=1" target="showNews">More</a></span>
                    </div>
                    <div class="news_list">
                        <c:if test="${!empty(list1)}" >
                            <ul>
                                <c:forEach var="news1" items="${list1}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/showNewsDetail?newsId=${news1.getNno()}" title="${news1.getNtitle()}" target="showNews">${news1.getNtitle()}</a>
                                        <span>${news1.getNcreateTime()}</span>
                                    </li>
                                </c:forEach>
                            </ul>
                        </c:if>
                    </div>
                </div>
                <div class="main_center">
                    <div class="news_1">
                        <h3>通知公告</h3>
                        <span><a href="${pageContext.request.contextPath}/showAllNewsByTypeId?TypeId=2" target="showNews">More</a></span>
                    </div>
                    <div class="news_list">
                        <c:if test="${!empty(list2)}" >
                            <ul>
                                <c:forEach var="news2" items="${list2}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/showNewsDetail?newsId=${news2.getNno()}" title="${news2.getNtitle()}" target="showNews">${news2.getNtitle()}</a>
                                        <span>${news2.getNcreateTime()}</span>
                                    </li>
                                </c:forEach>
                            </ul>
                        </c:if>
                    </div>
                </div>
                <div class="main_right">
                    <div class="news_1">
                        <h3>信息公开</h3>
                        <span><a href="${pageContext.request.contextPath}/showAllNewsByTypeId?TypeId=3" target="showNews">More</a></span>
                    </div>
                    <div class="news_list">
                        <c:if test="${!empty(list3)}" >
                            <ul>
                                <c:forEach var="news3" items="${list3}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/showNewsDetail?newsId=${news3.getNno()}" title="${news3.getNtitle()}" target="showNews">${news3.getNtitle()}</a>
                                        <span>${news3.getNcreateTime()}</span>
                                    </li>
                                </c:forEach>
                            </ul>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <div id="foot">
            <iframe name="showNews" frameborder="0" width="1300px" height="400px" marginheight="0" marginwidth="0" scrolling="no"></iframe>
        </div>
<%--        <c:if test="${!empty(list1)}" >--%>
<%--            <ul>--%>
<%--                <c:forEach var="news1" items="${list1}">--%>
<%--                    <li>--%>
<%--                        <a href="showNewsDetail?newsId=${news1.getNno()}">${news1.getNtitle()}</a>--%>
<%--                        <span>${news1.getNcreateTime()}</span>--%>
<%--                    </li>--%>
<%--                </c:forEach>--%>
<%--            </ul>--%>
<%--        </c:if>--%>
<%--        <c:if test="${!empty(list2)}" >--%>
<%--            <ul>--%>
<%--                <c:forEach var="news2" items="${list2}">--%>
<%--                    <li>--%>
<%--                        <a href="showNewsDetail?newsId=${news2.getNno()}">${news2.getNtitle()}</a>--%>
<%--                        <span>${news2.getNcreateTime()}</span>--%>
<%--                    </li>--%>
<%--                </c:forEach>--%>
<%--            </ul>--%>
<%--        </c:if>--%>
<%--        <c:if test="${!empty(list3)}" >--%>
<%--            <ul>--%>
<%--                <c:forEach var="news3" items="${list3}">--%>
<%--                    <li>--%>
<%--                        <a href="showNewsDetail?newsId=${news3.getNno()}">${news3.getNtitle()}</a>--%>
<%--                        <span>${news3.getNcreateTime()}</span>--%>
<%--                    </li>--%>
<%--                </c:forEach>--%>
<%--            </ul>--%>
<%--        </c:if>--%>

    </body>
</html>
