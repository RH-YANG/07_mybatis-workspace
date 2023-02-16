<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	<div class="outer" align="center">
		<br><h1 align="center">일반게시판 작성하기</h1><br>
		<form action="insert.bo" method="post">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" required></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="10" name="content" required></textarea>
					</td>
				</tr>
			</table><br>
			<button type="submit">작성하기</button>
			<button type="reset">취소하기</button><br><br>
		</form>
	</div>


</body>
</html>