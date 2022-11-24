<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcomeMember</title>
</head>
<body>
	welcome Member입니다.
	
	<%-- 
	<c:if test="${not empty pageContext.request.userPrincipal }">
		<p>is Log-In</p>
	</c:if>
	
	<c:if test="${empty pageContext.request.userPrincipal }">
		<p>is Log-Out</p>
	</c:if>
	
	USER ID : ${pageContext.request.userPrincipal.name} <br/>	
	
	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		어드민
	</sec:authorize>
	 --%>
	
	<sec:authorize access = "isAuthenticated()">
		<p>is Log-In</p>
	</sec:authorize>
	<sec:authorize access = "!isAuthenticated()">
		<p>is Log-Out</p>
	</sec:authorize>
	
	USER ID : <sec:authentication property="name" /><br/>
	
	
	<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
		<p>관리자 혹은 유저</p>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<p>관리자</p>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_USER')">
		<p>유저</p>
	</sec:authorize>
	
	<a href="/logout">Log Out</a> 
	
</body>
</html>