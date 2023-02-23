<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.board {
		border : 1px solid red;
		padding : 10px;
		margin: 5px;
	}
	.reply {
		border : 1px solid blue;
		margin:5px;
	}
</style>
</head>
<body>

	<c:forEach var="b" items="${ list }">		
		<div class="board">
			게시글번호 : ${ b.boardNo } <br>
			게시글제목 : ${ b.boardTitle } <br>
			게시글내용 : ${ b.boardContent } <br>
			
			<c:forEach var="r" items="${ b.replyList }">
				<div class="reply">
					댓글번호 : ${ r.replyNo }<br>
					댓글내용 : ${ r.replyContent }<br>
					작성일 : ${ r.createDate } <br>
				</div>				
			</c:forEach>
		</div>
	</c:forEach>

</body>
</html>