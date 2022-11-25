<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>

</head>

<body>

<table width="500" cellpadding="0" cellspacing="0" border="1">
	<tr>
		<td>번호</td>
		<td>작성자</td>
		<td>상품명</td>
		<td>상품설명</td>
		<td>가격</td>
		<td>재고</td>
		<td>삭제</td>
	</tr>
	
	<c:choose>
		<c:when test="${empty list}">
			<tr>
				<td colspan="7" align="center"><h2>등록된 게시물이 없습니다.</h2></td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.id}</td>
				<td>${dto.created_by}</td>
				<td><a href="view?id=${dto.id}">${dto.item_name}</a></td>
				<td>${dto.item_detail}</td>
				<td>${dto.price}</td>
				<td>${dto.stock}</td>
				<td>
					<a href="delete?id=${dto.id}">(☞ﾟヮﾟ)☞</a>
				</td>
			</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<p><a href="write">작 성</a></p>

</body>

</html>