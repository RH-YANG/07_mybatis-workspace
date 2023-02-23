<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	게시글제목 : ${ b.boardTitle } <br>
	게시글내용 : ${ b.boardContent } <br>
	조회수 : ${ b.count } <br><br>
	
	작성자아이디 : ${ b.mem.userId } <br>
	작성자이름 : ${ b.mem.userName } <br>
	작성자성별 : ${ b.mem.gender } <br>
</body>
</html>