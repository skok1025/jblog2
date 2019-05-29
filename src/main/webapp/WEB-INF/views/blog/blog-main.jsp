<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	pageContext.setAttribute("newline", "\n");
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/blog_header.jsp"/>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<c:if test="${empty postVo}">
						<h4 style="color: tomato; font-weight: bold;">게시물이 없습니다.</h4>
					</c:if>
					<h4>${postVo.title }</h4>
					<p>
						${fn:replace(postVo.content,newline,"<br>") }
					<p>
				</div>
				<ul class="blog-list">
					<c:forEach items="${postList}" var="post" varStatus="status">
						<li><a href="${pageContext.servletContext.contextPath }/${id}/${categoryOrder}/${status.index}">${post.title}</a> <span>${post.regDate}</span></li>					
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}/logos/${blogvo.logo}">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${categoryList}" var="category" varStatus="status">
					<li><a href="${pageContext.servletContext.contextPath }/${id}/${status.index}">${category.name }</a></li>				
				</c:forEach>
			</ul>
		</div>
		
		<c:import url="/WEB-INF/views/includes/blog_footer.jsp"/>
	</div>
</body>
</html>