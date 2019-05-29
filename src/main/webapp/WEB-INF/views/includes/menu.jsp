<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1 class="logo">JBlog</h1>
<ul class="menu">
	<c:if test="${empty sessionScope.authuser}">
		<li><a href="${pageContext.servletContext.contextPath}/user/login">로그인</a></li>
		<li><a href="${pageContext.servletContext.contextPath}/user/join">회원가입</a></li>
	</c:if>
	<c:if test="${not empty sessionScope.authuser}">
		<li><a href="${pageContext.servletContext.contextPath}/user/logout">로그아웃</a></li>
		<li><a href="${pageContext.servletContext.contextPath}/${sessionScope.authuser.id}">내블로그</a></li>
	</c:if>
</ul>