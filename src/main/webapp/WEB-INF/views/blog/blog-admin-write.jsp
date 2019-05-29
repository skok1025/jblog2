<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript">
	<c:if test='${addfail eq "false"}'>
		alert("포스트 추가실패하셨습니다.");
	</c:if>
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/blog_header.jsp"/>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<c:import url="/WEB-INF/views/includes/blog_menu.jsp">
					<c:param name="menu" value="write"/>
				</c:import> 
				<form:form modelAttribute="postVo" action="${pageContext.servletContext.contextPath }/${id}/admin/write" method="post">
			      	<table class="admin-cat-write">
			      		<tr>
			      			<td class="t">제목</td>
			      			<td>
			      				<form:input path="title" size="60"/>
				      			<select name="categoryNo">
				      				<c:forEach items="${categoryList }" var="categoryvo">
				      				<option value="${categoryvo.no }">${categoryvo.name }</option>
				      				</c:forEach>
				      			</select>
				      			<p
				style="font-weight: bold; color: tomato; text-align: left; padding: 0px; margin: 0px;">
				<form:errors path="title" />
			</p>
				      		</td>
				      		
			      		</tr>
			      		<tr>
			      			<td class="t">내용</td>
			      			<td>
			      			<form:textarea path="content"></form:textarea>
			      			<p
				style="font-weight: bold; color: tomato; text-align: left; padding: 0px; margin: 0px;">
				<form:errors path="content" />
			</p>
			      			</td>
			      			
			      		</tr>
			      		<tr>
			      			<td>&nbsp;</td>
			      			<td class="s"><input type="submit" value="포스트하기"></td>
			      		</tr>
			      	</table>
				</form:form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/blog_footer.jsp"/>
	</div>
</body>
</html>