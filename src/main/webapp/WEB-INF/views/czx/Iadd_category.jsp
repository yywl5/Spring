<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>添加公告分类</title>
    <link href="${pageContext.request.contextPath}/static/czx/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/findIcategorylist.action">公告列表</a></li>
    </ul>
</div>
<div class="formbody">
    <div class="formtitle"><span>添加公告类别</span></div>
    <form action="${pageContext.request.contextPath}/addCategory.action" name="ff" method="post" onsubmit="return checkValue()">
        <ul class="forminfo">
            <li><label style="width:150px;">公告名称（<font style="color:Red;font-weight:bolder;">*</font>）：</label><input id="categoryName" name="categoryName" type="text" class="dfinput" /><i></i></li>
            <li><label style="width:150px;">公告编号（<font style="color:Red;font-weight:bolder;">*</font>）：</label><input id="categoryId" name="categoryId" type="text" class="dfinput" /><i></i></li>
            <i></i></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认添加"/>
                &nbsp;&nbsp;<input name="" type="button" onclick="goback();"class="btn" value="返回列表"/></li>
        </ul>
    </form>
</div>
<script>
    function goback(){
        window.location.href="${pageContext.request.contextPath}/findIcategorylist.action";
    }
    function checkValue() {
        var str = document.getElementById("categoryName").value;
        if (str.length < 1) {
            alert("请输入公告信息");
            document.getElementById("categoryName").focus();
            return false;
        }
        if (str.length > 0 && str.length<2) {
            alert("分类名称应大于等于6");
            document.getElementById("categoryName").focus();
            return false;
        }
        if (str.length >30) {
            alert("输入目录名称名称过长");
            document.getElementById("categoryName").focus();
            return false;
        }
        return true;
    }
</script>
</body>
</html>