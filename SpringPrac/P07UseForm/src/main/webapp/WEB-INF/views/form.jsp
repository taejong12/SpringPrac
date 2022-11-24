<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form</title>
</head>
<body>
	<form action="test1">
		나이: <input type="number" name="age" /> <br>
		이름: <input type="text" name="name" /> <br>
		<button type="submit">제출</button>
	</form>
	
	이름:${name }
	나이:${age }
	
	
	<form method="get" action="test1">
		<fieldset>
			<legend>test1</legend>
			<label>이름:<input type="text" name="name" ></label>
			<label>나이:<input type="text" name="age"></label>
			<input type="submit" value="제출" />
		</fieldset>
	</form>
	
	<form method="get" action="test2">
		<fieldset>
			<legend>test2</legend>
			<label>이름:<input type="text" name="name" ></label>
			<label>나이:<input type="text" name="age"></label>
			<input type="submit" value="제출" />
		</fieldset>
	</form>
	
	
	<form method="get" action="test3">
		<fieldset>
			<legend>test322</legend>
			<label>이름:<input type="text" name="name" ></label>
			<label>나이:<input type="text" name="age"></label>
			<input type="submit" value="제출" />
		</fieldset>
	</form>
	
</body>
</html>