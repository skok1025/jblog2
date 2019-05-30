<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="header">
	<h1>${blogvo.title }</h1>
	<ul>
		<c:if test="${empty authuser}">
			<li><a
				href="${pageContext.servletContext.contextPath}/user/login">로그인</a></li>
		</c:if>
		<c:if test="${not empty authuser }">
			<li><a
				href="${pageContext.servletContext.contextPath}/user/logout">로그아웃</a></li>
			
			<c:if test="${authuser.id eq id }">
			<li><a
				href="${pageContext.servletContext.contextPath }/${id}/admin/basic">블로그
					관리</a></li>
			</c:if>
		</c:if>
		<li><a href="${pageContext.servletContext.contextPath}">메인으로 돌아가기</a></li>
	</ul>
</div>