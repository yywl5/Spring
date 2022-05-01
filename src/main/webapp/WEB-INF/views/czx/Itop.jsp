<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>top.jsp</title>
    <link href="${pageContext.request.contextPath}/static/czx/css/style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/Y0looo/bootstrap-3.4.1-dist/css/bootstrap.min.css" type="text/css"/>
    <!--引入JQuery的JS文件：JQuery的JS文件要在BootStrap的js的文件的前面引入-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/potatob6/js/jquery-3.6.0.min.js" ></script>
    <!--引入BootStrap的JS的文件-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/Y0looo/bootstrap-3.4.1-dist/js/bootstrap.min.js" ></script>
<script>
    $(function(){
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
</head>
<body style="background:url(${pageContext.request.contextPath}/static/czx/img/topbg.gif) repeat-x;">
    <div class="topleft">
    <a href="Imain.jsp" target="_parent"><img src="${pageContext.request.contextPath}/static/yywl5/iconfont/favicon.ico" title="系统首页" /></a>
    </div>        
    <ul class="nav">   
    </ul>            
    <div class="topright">    
    <ul>
    <li><span><img src="${pageContext.request.contextPath}/static/czx/img/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="#" onclick="logout();">退出</a></li>
    </ul>
     
    <div class="user">
    <span>${sessionScope.login_user.userName }</span>
    </div>    
    
    </div>
    
    
     <script type="text/javascript">
		function logout(){
			if(window.confirm("您确定要退出吗？"))
			{
			   top.location.href="${pageContext.request.contextPath}/logout.action";
			 }else{
				 return false;
			 }
		}
	</script>
</body>
</html>
