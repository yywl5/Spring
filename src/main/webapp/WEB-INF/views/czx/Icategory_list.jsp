<%@ page import="Beans.czx.ICategory" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公共以及图书类别目录</title>
    <link href="${pageContext.request.contextPath}/static/czx/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/potatob6/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">公告分类列表</a></li>
    </ul>
</div>
<div class="rightinfo">
    <div class="tools">
        <ul class="toolbar">
            <li class="click"><a href="${pageContext.request.contextPath}/toAddcategory.action"><span><img src="${pageContext.request.contextPath}/static/czx/img/t01.png" /></span>添加分类</a></li>
        </ul>
    </div>

    <table class="tablelist" >
        <thead>
        <tr>
            <th style="width:100px;text-align:center;">分类id</th>
            <th style="width:120px;text-align:center;">分类名称</th>
            <th style="width:200px;text-align:center;">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${!empty IcategoryList}">
            <c:forEach items="${IcategoryList}" var="Icategory">
                <tr>
                    <td align="center">${Icategory.categoryId}</td>
                    <td align="center">${Icategory.categoryName}</td>
                    <td align="center">
                        <a href="${pageContext.request.contextPath}/toEditCategory.action?categoryId=${Icategory.categoryId}">修改</a>
                            &nbsp;|&nbsp;<a href='#' onclick="delICategory(${Icategory.categoryId})">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
    <script type="text/javascript">
        function disableICategory(categoryId){
            $.ajax({
                url:"${pageContext.request.contextPath}/disableUser.action",
                type:"post",
                //data表示发送的数据
                data:JSON.stringify({categoryId:categoryId}),
                // 定义发送请求的数据格式为JSON字符串
                contentType:"application/json;charset=UTF-8",
                //定义回调响应的数据格式为JSON字符串，该属性可以省略
                dataType:"json",
                //成功响应的结果
                success:function(data){
                    if(data!=null){
                        if(data.categoryId>0){
                            alert("禁用成功！");
                            window.location.reload();
                        }else{
                            alert("禁用失败！");
                            window.location.reload();
                        }
                    }
                }
            },1000);
        }
        function enableICategory(categoryId){
            $.ajax({
                url:"${pageContext.request.contextPath}/enableUser.action",
                type:"post",
                //data表示发送的数据
                data:JSON.stringify({categoryId:categoryId}),
                // 定义发送请求的数据格式为JSON字符串
                contentType:"application/json;charset=UTF-8",
                //定义回调响应的数据格式为JSON字符串，该属性可以省略
                dataType:"json",
                //成功响应的结果
                success:function(data){
                    if(data!=null){
                        if(data.categoryId>0){
                            alert("启用成功！");
                            window.location.reload();
                        }else{
                            alert("启用失败！");
                            window.location.reload();
                        }
                    }
                }
            },1000);
        }
        function delICategory(categoryId){
            if(window.confirm("您确定要删除吗？"))
            {
                $.ajax({
                    url:"${pageContext.request.contextPath}/delCategory.action",
                    type:"post",
                    //data表示发送的数据
                    data:JSON.stringify({categoryId:categoryId}),
                    // 定义发送请求的数据格式为JSON字符串
                    contentType:"application/json;charset=UTF-8",
                    //定义回调响应的数据格式为JSON字符串，该属性可以省略
                    dataType:"json",
                    //成功响应的结果
                    success:function(data){
                        if(data!=null){
                            if(data.categoryId>0){
                                alert("删除成功！");
                                window.location.reload();
                            }else{
                                alert("删除失败！");
                                window.location.reload();
                            }
                        }
                    }
                },1000);
            }
        }
    </script>
</div>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>