<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
  $( function() {
    var availableTags = [
    	<c:forEach items="${userlist}" var="uservo">
			"${uservo.id }",
		</c:forEach>
    ];
    $( "#tags" ).autocomplete({
      source: availableTags
    });
  } );
  </script>


<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div class="center-content">
		<c:import url="/WEB-INF/views/includes/menu.jsp"/>
		<form class="search-form" method="get" action="${pageContext.servletContext.contextPath }/sh">
			<fieldset>
				<input type="text" id="tags" name="keyword" />
				<input type="submit" value="검색" />
			</fieldset>
			<fieldset>
				<input type="radio" name="which" value="blog-title" disabled="disabled"> <label>블로그 제목</label>
				<input type="radio" name="which" value="tag" disabled="disabled"> <label>태그</label>
				<input type="radio" name="which" value="userid" checked="checked"> <label>블로거</label>
			</fieldset>
		</form>
	</div>
</body>
</html>