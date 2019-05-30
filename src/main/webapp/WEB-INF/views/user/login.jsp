<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<script type="text/javascript">
	<c:if test='${param.loginfail eq "yes"}'>
	alert("로그인에 실패하셨습니다.");
	</c:if>
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.9.0.js"></script>
</head>
<body>
	<div class="center-content">
		<c:import url="/WEB-INF/views/includes/menu.jsp" />
		<form class="login-form" method="get"
			action="${pageContext.servletContext.contextPath }/user/auth">
			<label>아이디</label> <input type="text" name="id"> <label>패스워드</label>
			<input type="password" name="password"> <input type="submit"
				value="로그인">
				
		</form>
	</div>
	<a href="${pageContext.servletContext.contextPath}">메인으로 돌아가기</a>
</body>
</html>
