<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit</title>
</head>

<body>
<form action="updatingOne" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${ dto.id }" />
	<table>
		<tr>
			<td>번호</td>
			<td>${dto.id }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${dto.writer}</td>
		</tr>
		<tr>
			<td>상품명</td>
			<td>
				<input type="text" name="iname" value="${dto.iname }" />
			</td>
		</tr>
		<tr>
			<td>상품설명</td>
			<td>
				<textarea name="idetail">${dto.idetail }</textarea>
			</td>
		</tr>
		<tr>
			<td>상태</td>
			<td>${dto.istatus}</td>
			<td>
				<select name="istatus">
				    <option value="판매중">판매중</option>
				    <option value="품절">품절</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>가격</td>
			<td>
				<input type="number" name="price" value="${dto.price }"/>
			</td>
		</tr>
		<tr>
			<td>재고</td>
			<td>
				<input type="number" name="stock" value="${dto.stock }"/>
			</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>${dto.time}</td>
		</tr>
	</table>
		<input type="submit" value="수정완료" /><br/>
		<a href="listOne">목록</a>
</form>
</body>
</html>