<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link href="https://fonts.googleapis.com/css?family=ZCOOL+KuaiLe&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
<style type="text/css">

	#ops{
		font-size:5em;
		font-weight:bold;
		margin: 50px 0px 50px 0px;
		color: tomato;
		font-family: 'ZCOOL KuaiLe', cursive;
	}
	
	#contents{
		font-size: 2em;
		font-family: 'Do Hyeon', sans-serif;
		margin: 50px 0px 50px 0px;
	}

</style>

</head>
<body>
	<div class="center-content">
		<h1 class="logo">JBlog</h1>
		
		<p id="ops">Oooops!</p>
		<p id="contents">
			죄송합니다. <br /> 요청하신 페이지를 찾을 수 없습니다. <br /> 잠시후, 다시 사용해주세요.
		</p>
		<a href="${pageContext.servletContext.contextPath}">메인으로 돌아가기</a>
	</div>
</body>
</html>


