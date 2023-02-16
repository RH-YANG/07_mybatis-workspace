<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String year = new java.text.SimpleDateFormat("yyyy").format(new java.util.Date());
	%>
	Copyright ⓒ 2000 - <%= year %> GooDee Academy. All rights reserved.
	<br>
	
	test : ${ param.test } 


</body>
</html>