<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>jsp:forward</h3>
	<p>또 다른 페이지로 바로 포워딩하고자 할 때</p>

	<% if(10 > 3) { %>
		<jsp:forward page="footer.jsp">
			<jsp:param name="test" value="Hello"/>
		</jsp:forward>
	<% }else { %>
		<jsp:forward page="../01_EL/elBasic.jsp"/>
	<% } %>
</body>
</html>