<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>right.jsp</title>
	<link href="${pageContext.request.contextPath}/static/czx/css/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/Y0looo/bootstrap-3.4.1-dist/css/bootstrap.min.css" type="text/css"/>
	<!--引入JQuery的JS文件：JQuery的JS文件要在BootStrap的js的文件的前面引入-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/potatob6/js/jquery-3.6.0.min.js" ></script>
	<!--引入BootStrap的JS的文件-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/Y0looo/bootstrap-3.4.1-dist/js/bootstrap.min.js" ></script>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    </ul>
    </div>
    <div class="mainindex">
    <div class="welinfo">
    <b> ${sessionScope.login_user.userName }，你好！欢迎使用文章发布管理系统</b>
    </div>
    <div class="xline"></div>
    <ul class="iconlist">
			<c:choose>
				<c:when test="${sessionScope.login_user.roleId==1}">
				<li><img src="${pageContext.request.contextPath}/static/czx/img//ico07.png"
						style="width: 50px; height: 50px;" />
					<p>
							<a href="${pageContext.request.contextPath}/findUserList.action">用户管理</a>
						</p></li>
					<li><img src="${pageContext.request.contextPath}/static/czx/img//ico03.png"
						style="width: 50px; height: 50px;" />
					<p>
							<a href="${pageContext.request.contextPath}/findCategoryList.action">信息类别管理</a>
						</p></li>
				</c:when>
				<c:when test="${sessionScope.login_user.roleId==2}">
					<li><img src="${pageContext.request.contextPath}/static/czx/img//ico06.png"
						style="width: 50px; height: 50px;" />
					<p>
							<a href="${pageContext.request.contextPath}/findNewsByPage.action">查询文章</a>
						</p></li>
					<li><img src="${pageContext.request.contextPath}/static/czx/img/ico02.png"
						style="width: 50px; height: 50px;" />
					<p>
							<a href="${pageContext.request.contextPath}/toAddNews.action">发布文章</a>
						</p></li>
				</c:when>
			</c:choose>
		</ul>        
    </div>
</body>
</html>
