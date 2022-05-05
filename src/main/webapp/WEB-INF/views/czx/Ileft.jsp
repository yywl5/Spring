<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>left.jsp</title>
	<link href="${pageContext.request.contextPath}/static/czx/css/style.css" rel="stylesheet" type="text/css" />
	<!--引入JQuery的JS文件：JQuery的JS文件要在BootStrap的js的文件的前面引入-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/potatob6/js/jquery-3.6.0.min.js" ></script>
	<!--引入BootStrap的JS的文件-->
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
	    console.log(1111);
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
</head>
<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>管理菜单</div>
	<c:choose>
		<c:when test="${sessionScope.login_user.roleId==1}">
			<dl class="leftmenu">
				<dd>
					<div class="title">
						<span><img src="${pageContext.request.contextPath}/static/czx/img/leftico04.png" /></span>用户管理
					</div>
					<ul class="menuson">
						<li><cite style="margin-left: -4px;"></cite><a href="${pageContext.request.contextPath}/findUserList.action"
							target="rightFrame">用户列表</a><i></i></li>
						<li><cite></cite><a href="${pageContext.request.contextPath}/toAddUser.action"
							target="rightFrame">添加用户</a><i></i></li>
					</ul>
				</dd>
				<dd>
					<div class="title">
						<span><img src="${pageContext.request.contextPath}/static/czx/img/leftico02.png" /></span>文章类别管理
					</div>
					<ul class="menuson">
						<li><cite></cite><a href="${pageContext.request.contextPath}/findIcategorylist.action"
							target="rightFrame">图书类别列表</a><i></i></li>
						<li><cite></cite><a href="${pageContext.request.contextPath}/toAddcategory.action"
											target="rightFrame">添加图书类别</a><i></i></li>
						`
					</ul>
				</dd>
			</dl>
		</c:when>
		<c:when test="${sessionScope.login_user.roleId==2}">
			<dl class="leftmenu">
				<dd>
					<div class="title">
						<span><img src="${pageContext.request.contextPath}/static/czx/img/leftico01.png" /></span>文章管理
					</div>
					<ul class="menuson">
						<li><cite style="margin-left: -4px;"></cite><a href="${pageContext.request.contextPath}/findNewsByPage.action"
							target="rightFrame">文章列表</a><i></i></li>
						<li><cite></cite><a href="${pageContext.request.contextPath}/toAddNews.action"
							target="rightFrame">发布新文章</a><i></i></li>
					</ul>
				</dd>
			</dl>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
</body>
</html>