<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view</title>
</head>
<body>
내용보기<br/>
<hr>
번호: ${dto.id }<br/>
작성자: ${dto.writer}<br/>
상품명: ${dto.iname }<br/>
상품설명: ${dto.idetail }<br/>
상태: ${dto.istatus}<br/>
가격: ${dto.price }<br/>
재고: ${dto.stock }<br/>
날짜: ${dto.time}

<hr>
<br/>
<p><a href="listOne">목록보기</a></p>
</body>
</html>

