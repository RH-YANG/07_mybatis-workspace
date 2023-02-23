<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	게시글제목 : ${ b.boardTitle } <br>
	게시글내용 : ${ b.boardContent } <br><br>
	
	<c:forEach var="r" items="${ b.replyList }">
		댓글번호 : ${ r.replyNo } <br>
		댓글내용 : ${ r.replyContent } <br>
		작설일 : ${ r.createDate } <br><br>
	</c:forEach>
	
</body>
</html>