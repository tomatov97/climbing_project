<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/font.css">
</head>
<body>
	<div class="container-fluid">
		<header
			class="d-flex flex-wrap justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
			<a href="/rockmate/main/routeList.jsp?pageNumber=1&gymId=${gymId }"
				class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
				<span>Rock Mate</span>
			</a>
			<div>
				<ul>
					<%-- 로그인을 하지 않은 상태 --%>
					<c:if test="${loginMember eq null}">
						<li><a href="/rockmate/member/login.jsp" class="nav-link px-2 link-secondary">로그인</a></li>
						<li><a href="/rockmate/member/join.jsp" class="nav-link px-2 link-dark">회원가입</a></li>
					</c:if>

					<%-- 로그인을 한 상태 --%>
					<c:if test="${loginMember ne null}">
						<li><a href="/rockmate/member/login.jsp" class="nav-link px-2 link-secondary">회원 정보 수정</a></li>
						<li><a href="/rockmate/member/login" class="nav-link px-2 link-dark">로그아웃</a></li>
					</c:if>
					
				</ul>
			</div>
		</header>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>