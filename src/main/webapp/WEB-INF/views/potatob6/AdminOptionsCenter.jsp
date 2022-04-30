<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!--引入标签库-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <script src="${pageContext.request.contextPath}/static/potatob6/js/axios.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/potatob6/js/jquery-3.6.0.min.js"></script>
    <title>管理图书</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            font-size: 1.1rem;
        }

        body {
            position: relative;
            width: 100vw;
            height: 100vh;
            background: url("${pageContext.request.contextPath}/static/potatob6/svg/AdminPage_bg.svg") center center no-repeat;
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-content: center;
        }

        #selfCenter {
            margin: 50px;
            left: 50px;
            top: 50px;
            width: 400px;
            bottom: 50px;
            backdrop-filter: blur(2rem);
            -webkit-backdrop-filter: blur(2rem);
            box-shadow: 0 0 18px rgba(70,70,70,0.2);
            border: 1px solid #dbe2ef;
            flex-shrink: 0;
            border-radius: 10px;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            transition: all 0.3s;
            overflow: hidden;
        }

        #items {
            width: 100%;
            margin: 50px;
            margin-left: 0;
            min-width: 700px;
            flex-shrink: 1;
            backdrop-filter: blur(1.5rem);
            -webkit-backdrop-filter: blur(1.5rem);
            border: 1px solid #dbe2ef;
            border-radius: 10px;
            box-shadow: 0 0 18px rgba(70,70,70,0.2);
            display: flex;
            flex-direction: column;
            overflow: hidden;
        }

        img {
            width: auto;
            height: 50%;
        }

        p {
            flex-shrink: 0;
        }

        #avatar {
            width: 100px;
            height: 100px;
            border-radius: 50px;
        }

        hr {
            width: 60%;
            height: 4px;
            background-color: rgba(70,70,70,0.3);
            border-radius: 2px;
            border: none;
            margin: 40px 0;
        }

        p {
            margin: 20px 0;
        }

        img:hover {
            cursor: pointer;
        }

        #items_top {
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: flex-start;
            flex-shrink: 0;
            background-color: #005691;
            border-radius: 10px 10px 0 0;
        }

        #items_top > * {
            margin: 16px 0;
            color: white;
        }

        tr, tbody {
            width: 100%;
        }

        td, th {
            text-align: center;
            margin: 10px 0;
            word-break: keep-all;
        }

        table {
            width: 100%;
            padding: 20px;
        }

        button {
            width: 80px;
            height: 40px;
            border-radius: 7px;
            background-color: #17b978;
            outline: none;
            border: none;
            transition: all 0.3s;
            color: white;
            font-size: small;
        }

        button:hover {
            cursor: pointer;
        }

        #page_bar {
            width: 100%;
            height: 50px;
            position: absolute;
            bottom: 0;
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
            flex-shrink: 0;
        }

        .opera {
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
        }

        .opera > button {
            margin: 0 2px;
        }

        .lists {
            flex-shrink: 1;
            overflow-y: scroll;
        }

        #fold {
            position: absolute;
            width: 100%;
            height: 54px;
            background-color: #005691;
            top: 0; left: 0;
            display: flex;
            flex-direction: row;
            justify-content: flex-start;
            border-radius: 10px 10px 0 0;
        }

        input {
            max-width: 150px;
            height: 40px;
            border-radius: 7px;
            outline: none;
            border: 1px solid #52616b;
            text-align: center;
            background: transparent;
        }
    </style>
</head>

<body>
<div id="selfCenter">
    <div id="fold">
        <img src="${pageContext.request.contextPath}/static/potatob6/svg/fold.svg" onclick="fold()" style="margin: 12px 20px; width: 30px; height: 30px" />
    </div>
    <c:if test="${admin.avatarPath == null || admin.avatarPath.equals(\"\")}">
        <img width="100" id="avatar" height="100" src="${pageContext.request.contextPath}/static/avatars/default.svg" />
    </c:if>

    <c:if test="${!(admin.avatarPath == null || admin.avatarPath.equals(\"\"))}">
        <img width="100" id="avatar" height="100" src="${pageContext.request.contextPath}/${admin.avatarPath}" />
    </c:if>
    <hr>
    <p>欢迎，${admin.adminName}</p>
    <p>管理员编号:${admin.adminId}</p>
    <p>图书管理后台系统</p>
    <hr>
</div>
<div id="items">
    <div id="items_top">
        <div style="width: 20px; flex-shrink: 0"></div>
        <img onclick="window.location.href=${pageContext.request.contextPath}/Admin/" style="width: 22px; height: 22px; flex-shrink: 0" src="${pageContext.request.contextPath}/static/potatob6/svg/return.svg" />
        <p style="flex-shrink: 1; margin: 0;margin-left: 20px;margin-top: 16px;width: 100%;text-align: center">设置中心</p>
        <div style="width: 20px; flex-shrink: 0"></div>
    </div>

    <div style="display: flex; justify-content: center; align-items: center;flex-direction: column">
        <p style="margin-top: 40px">上传头像</p>
        <c:if test="${admin.avatarPath == null || admin.avatarPath.equals(\"\")}">
            <img style="height: 100px; width: auto" id="avatar2" src="${pageContext.request.contextPath}/static/avatars/default.svg" onclick="avatarUpload()">
        </c:if>

        <c:if test="${!(admin.avatarPath == null || admin.avatarPath.equals(\"\"))}">
            <img style="height: 100px; width: auto" id="avatar2" src="${pageContext.request.contextPath}/${admin.avatarPath}" onclick="avatarUpload()">
        </c:if>
        <p>名称</p>
        <input value="${admin.adminName}" id="adminName">
        <p>密码</p>
        <input value="${admin.adminPassword}" id="adminPassword">
        <button style="margin-top: 40px" onclick="commit()">保存</button>
    </div>

</div>
<script lang="JavaScript">
    var folded = false;
    function fold() {
        if(folded) {
            $("#selfCenter").css("width", "400px")
            let chs = document.getElementById("selfCenter").children
            for (var i = 1; i < chs.length; i++) {
                chs[i].style.opacity = "1";
            }
        } else {
            $("#selfCenter").css("width", "70px")
            let chs = document.getElementById("selfCenter").children
            for (var i = 1; i < chs.length; i++) {
                chs[i].style.opacity = "0";
            }
        }
        folded = !folded
    }
</script>
<script lang="JavaScript">
    var avatarPath = "${admin.avatarPath}";
    function commit() {
        axios({
            url: '${pageContext.request.contextPath}/admin/options/commit',
            data: {
                adminName: document.getElementById("adminName").value,
                adminPassword: document.getElementById("adminPassword").value,
                avatarPath: avatarPath
            },
            method: 'POST'
        }).then(response => {
            let resp = JSON.parse(response.data);
            if(resp.status !== undefined && resp.status === 'success') {
                alert("更改成功");
            }
        })
    }
    function avatarUpload() {

        let avatarSelect = document.createElement("input");
        avatarSelect.type = 'file';
        avatarSelect.onchange = () => {
            upload(avatarSelect.files[0]);
        }
        avatarSelect.click();
    }

    function upload(file) {
        let data = new FormData();
        data.append("file", file);
        axios({
            url: '${pageContext.request.contextPath}/admin/options/upload',
            data: data,
            method: 'POST',
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        }).then(response => {
            let resp = JSON.parse(response.data);
            if(resp.status !== undefined && resp.status === 'success') {
                avatarPath = resp.path;
                let fileReader = new FileReader();
                fileReader.readAsDataURL(file);
                fileReader.onload = (e) => {
                    let arr = e.target.result.split(',');
                    document.getElementById('avatar2').src = 'data:image/png;base64,'+arr[1];
                    document.getElementById('avatar').src  = 'data:image/png;base64,'+arr[1];
                }
                console.log(avatarPath);
            }
        })
    }
</script>
</body>
</html>