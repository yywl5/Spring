<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/dqy/css/base.css"/>
        <script type="text/javascript" language="javascript">
            function checkNotice(){
                var title = form1.title.value;
                if ((title==null)||(title=="")){
                    alert("请填写标题！");
                    return false;
                }
                var editor = form1.editor.value;
                if ((editor==null)||(editor=="")){
                    alert("请填写时间！");
                    return false;
                }
                var content = form1.content.value;
                if ((content==null)||(content=="")){
                    alert("请填写内容！");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body class=" dashboard">
        <div id="container">
            <div id="header">
                <div id="branding">
                    <h1 >星星图书馆后台发布系统</h1>
                </div>
                <div id="user-tools">
                    <a href="#">个人信息</a> /
                    <a href="#">返回主页</a>
                </div>
            </div>
            <div id="content" margin-right: 600px;>
                <div id="content-main">
                    <h1><b>编辑新闻</b></h1><br>
                    <div>
                        <form method="post" action="" onsubmit="javascript: return checkNotice();">
                            <table>
                                <tr>
                                    <td>标题:</td>
                                    <td><input type="text" name="title" size="50" value="${news.getNtitle()}"/></td>
                                </tr>
                                <tr>
                                    <td>时间:</td>
                                    <td><input type="text" name="createTime" size="50" value="${news.getNcreateTime()}" readonly="readonly"/></td>
                                </tr>
                                <tr>
                                    <td>作者:</td>
                                    <td><input type="text" name="editor" size="50" value="${news.getNeditor()}"></td>
                                </tr>
                                <tr>
                                    <td>内容:</td>
                                    <td><textarea name="content" rows="20" cols="60" >${news.getNcontent()}</textarea></td>
                                </tr>
                                <tr>
                                    <td>通知类型:</td>
                                    <td><select name="type" >
                                        <option>综合新闻</option>
                                        <option>通知公告</option>
                                        <option>具体公开</option>
                                    </select></td>
                                </tr>
                                <tr>
                                    <td><input type="submit" value="提交" name="submit"/></td>
                                    <td><input type="reset" value="重置" name="reset"/></td>
                                </tr>
                            </table>
                        </form>

                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
