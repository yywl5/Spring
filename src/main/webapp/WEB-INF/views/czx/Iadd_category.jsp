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
        <li><a href="${pageContext.request.contextPath}/findUserList.action">公告列表</a></li>
    </ul>
</div>
<div class="formbody">
    <div class="formtitle"><span>添加公告类别</span></div>
    <form action="${pageContext.request.contextPath}/addUser.action" name="ff" method="post" onsubmit="return checkValue()">
        <ul class="forminfo">
            <li><label style="width:150px;">公告名称（<font style="color:Red;font-weight:bolder;">*</font>）：</label><input id="categoryName" name="categoryName"  value="${.userName}" type="text" class="dfinput" /><i></i></li>
                <i></i></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认添加"/>
                &nbsp;&nbsp;<input name="" type="button" onclick="goback();"class="btn" value="返回列表"/></li>
        </ul>
    </form>
</div>
<script>
    function goback(){
        window.location.href="${pageContext.request.contextPath}/findUserList.action";
    }
    function checkValue() {
        var str = document.getElementById("loginName").value;
        if (str.length < 1) {
            alert("请输入登录账号");
            document.getElementById("loginName").focus();
            return false;
        }
        str = document.getElementById("password").value;
        if (str.length < 1) {
            alert("请输入密码");
            document.getElementById("password").focus();
            return false;
        }
        if (str.length > 0 && str.length<6) {
            alert("密码长度应大于等于6");
            document.getElementById("password").focus();
            return false;
        }
        str = document.getElementById("userName").value;
        if (str.length < 1) {
            alert("请输入用户姓名");
            document.getElementById("userName").focus();
            return false;
        }
        str = document.getElementById("roleId").value;
        if (str == '') {
            alert("请选择用户角色");
            return false;
        }
        return true;
    }
</script>
</body>
</html>