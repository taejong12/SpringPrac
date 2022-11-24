<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy Ticket</title>
</head>
<body>
	<p>카드 결제</p>
	<form action="buy_ticket_card">
		고객아이디:<input type="text" name="consumerId"/><br/>
		티켓 구매수:<input type="text" name="amount" /><br/>
		에러 발생:<input type="text" name="error" value="0" /><br/>
		<input type="submit" value="구매" /><br/>
	</form>
	
</body>
</html>