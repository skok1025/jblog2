<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<ul class="admin-menu">
	<li <c:if test='${param.menu eq "basic"}'>class="selected"</c:if>>
		<c:if test='${param.menu != "basic"}'>
			<a href="${pageContext.servletContext.contextPath }/${id}/admin/basic">기본설정</a>
		</c:if>
		<c:if test='${param.menu eq "basic"}'>
			기본설정
		</c:if>
	</li>
	<li <c:if test='${param.menu eq "category"}'>class="selected"</c:if>>
		<c:if test='${param.menu != "category"}'>
			<a href="${pageContext.servletContext.contextPath }/${id}/admin/category">카테고리</a>
		</c:if>
		<c:if test='${param.menu eq "category"}'>
			카테고리
		</c:if>
	</li>
	<li <c:if test='${param.menu eq "write"}'>class="selected"</c:if>>
		<c:if test='${param.menu != "write"}'>
			<a href="${pageContext.servletContext.contextPath }/${id}/admin/write">글작성</a>
		</c:if>
		<c:if test='${param.menu eq "write"}'>
			글작성
		</c:if>
	</li>
</ul>