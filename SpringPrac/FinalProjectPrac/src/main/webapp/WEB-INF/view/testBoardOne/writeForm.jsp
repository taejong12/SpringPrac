<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeForm</title>
</head>
<body>
	<form action="writingOne" method="post" enctype="multipart/form-data">
		작성자: <input type="text" name="writer"  /><br/>
		상품명: <input type="text" name="iname" /><br/>
		상품내용: <input type="text" name="idetail"  /><br/>
		상태: <select name="istatus">
			    <option value="판매중">판매중</option>
			    <option value="품절">품절</option>
			</select> <br/>
		가격: <input type="number" name="price"/> <br/>
		재고: <input type="number" name="stock"/> <br/>
		날짜: <input type="date" name="time"/> <br/>
		
		<input type="submit" value="입력" /><br/>
		<a href="listOne">목록</a>
	</form>
</body>
</html>