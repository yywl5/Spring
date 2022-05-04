<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件列表</title>
</head>
<body>
	<h2>文件上传成功！</h2>
	文件列表(下载方式一)：<br />
	<c:forEach var="fileName" items="${filesFileName}">
		<c:url value="/download1" var="fileUrl">
			<c:param name="fileName" value="${fileName}"/>
		</c:url>
		<a href="${fileUrl}">${fileName }</a>
		<br />
	</c:forEach>
	
	<hr />
	文件列表(下载方式二)：<br />
	<c:forEach var="fileName" items="${filesFileName}">
		<c:url value="/download2" var="fileUrl">
			<c:param name="fileName" value="${fileName}"/>
		</c:url>
		<a href="${fileUrl}">${fileName }</a>
		<br />
	</c:forEach>
	
	<hr />
	文件列表(下载方式三)：<br />
	<c:forEach var="fileName" items="${filesFileName}">
		<c:url value="/download3" var="fileUrl">
			<c:param name="fileName" value="${fileName}"/>
		</c:url>
		<a href="${fileUrl}">${fileName }</a>
		<br />
	</c:forEach>
	
		<hr />
	文件列表(直接显示图片)：<br />
	<c:forEach var="fileName" items="${filesFileName}">
		<c:url value="/download4" var="fileUrl">
			<c:param name="fileName" value="${fileName}"/>
		</c:url>
		<a href="${fileUrl}">${fileName }</a> <br/>
		<img src="${fileUrl}"/>
		<br />
	</c:forEach>
</body>
</html>