<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript">
	<c:if test='${deletefail eq "yes"}'>
	alert("삭제에 실패했습니다");
	</c:if>
	<c:if test='${addfail eq "yes"}'>
	alert("등록에 실패했습니다");
	</c:if>
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/blog_header.jsp"/>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<c:import url="/WEB-INF/views/includes/blog_menu.jsp">
					<c:param name="menu" value="category"/>
				</c:import>
				<table class="admin-cat">
					<tr>
						<th>번호</th>
						<th>카테고리명</th>
						<th>포스트 수</th>
						<th>설명</th>
						<th>삭제</th>
					</tr>
					
					<c:forEach items="${categoryList }" var="categoryvo" varStatus="status">

						<tr>
							<td>${status.index+1}</td>
							<td>${categoryvo.name }</td>
							<td>${categoryvo.postCount }</td>
							<td>${categoryvo.description }</td>
							<td><a
								href="${pageContext.servletContext.contextPath }/${id}/admin/category/del/${categoryvo.no}"><img
									src="${pageContext.request.contextPath}/assets/images/delete.jpg"></a></td>
						</tr>
					</c:forEach>


				</table>

				<h4 class="n-c">새로운 카테고리 추가</h4>
				<form:form modelAttribute="categoryVo" action="${pageContext.servletContext.contextPath }/${id}/admin/category/add" method="post">
					
					<table id="admin-cat-add">
						<tr>
							<td class="t">카테고리명</td>
							<td>
							<form:input path="name"/>
							<p
				style="font-weight: bold; color: tomato; text-align: left; padding: 0px; margin: 0px;">
				<form:errors path="name" />
			</p>
							</td>
						</tr>
						<tr>
							<td class="t">설명</td>
							<td><input type="text" name="description"></td>
						</tr>
						<tr>
							<td class="s">&nbsp;</td>
							<td><input type="submit" value="카테고리 추가"></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/blog_footer.jsp"/>
	</div>
</body>
</html>