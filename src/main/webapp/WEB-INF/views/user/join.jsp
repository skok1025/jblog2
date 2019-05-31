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

<script
	src="<%=request.getContextPath()%>/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
	<c:if test='${joinfail eq "yes"}'>
	alert("회원가입에 실패하셨습니다. 다시 시도해주시기 바랍니다.");
	</c:if>

	$(function() {
		
		$("#blog-id").keydown(function() {
			$("#btn-checkemail").show();
			$("#img-checkemail").hide();
			$("#submitbt").attr("disabled","true");
			//document.getElementById("submitbt").disabled = true;
		});

		$("#btn-checkemail")
				.click(
						function() {
							var id = $("#blog-id").val();
							if (id == '') {
								return;
							}

							$
									.ajax({
										url : "${pageContext.servletContext.contextPath}/user/api/checkid?id="
												+ id,
										type : "get",
										dataType : "json",
										data : "",
										success : function(response) {
											if (response.result != 'success') {
												console.log(response);
												return;
											}
											if (response.data == true) {
												console.log(response);
												alert("이미 존재하는 아이디 입니다.\n다른 아이디를 사용하세요.");
												$("#blog-id").focus().val("");
												return;
											}
											$("#btn-checkemail").hide();
											$("#img-checkemail").show();
											$("#submitbt").removeAttr("disabled");
										}
									});
						});

	});
</script>
</head>
<body>
	<div class="center-content">
		<c:import url="/WEB-INF/views/includes/menu.jsp" />
		<form:form modelAttribute="usersVo" class="join-form" id="join-form"
			method="post"
			action="${pageContext.servletContext.contextPath }/user/join">
			<label class="block-label" for="name">이름</label>
			<form:input path="name"/>
			<p
				style="font-weight: bold; color: tomato; text-align: left; padding: 0px; margin: 0px;">
				<form:errors path="name" />
			</p>

			<label class="block-label" for="blog-id">아이디</label>
			<form:input id="blog-id" path="id"/>
			<input id="btn-checkemail" type="button" value="id 중복체크">
			<img id="img-checkemail" style="display: none;"
				src="${pageContext.request.contextPath}/assets/images/check.png">
			<p
				style="font-weight: bold; color: tomato; text-align: left; padding: 0px; margin: 0px;">
				<form:errors path="id" />
			</p>
			<label class="block-label" for="password">패스워드</label>
			<form:password  path="password" />
			<p
				style="font-weight: bold; color: tomato; text-align: left; padding: 0px; margin: 0px;">
				<form:errors path="password" />
			</p>

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input id="submitbt" type="submit" value="가입하기" disabled="disabled" >

		</form:form>
	</div>
	<a href="${pageContext.servletContext.contextPath}">메인으로 돌아가기</a>
</body>
</html>
