<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>jsp:include</h3>
	<p>또 다른 페이지를 포함하고자 할 때 쓰는 태그</p>
	
	<h4>1. 기존의 include 지시어를 이용하는 방식</h4>
	<%-- 
	<%@ include file="footer.jsp" %>
	<br><br>
	
	특징 : include 하고 있는 jsp상에 선언된 변수를 현재 이 jsp에서도 사용 가능 <br>
	year : <%= year %> <br><br>
	
	=> 단, 현재 이 jsp에서 동일한 이름의 변수를 재선언할 수 없음 <br>
	<% int year = 2021; %>
	--%>
	
	<h4>2. JSP표준액션 태그를 이용한 방식</h4>
	
	<%-- <jsp:include page="footer.jsp"></jsp:include> --%>
	<jsp:include page="footer.jsp" />
	<br><br>
	
	특징1 : include하고 있는 jsp상에 선언된 변수를 공유하지 않음 <br>
		   => 동일한 이름의 변수로 재선언 가능 <br><br>
	<% int year = 2021; %>
	
	특징2 : 해당 그 페이지를 포함할 때 include하는 페이지로 값 전달할 수 있음 <br>
	<jsp:include page="footer.jsp">
		<jsp:param name="test" value="Hello"/>
	</jsp:include>
	<br><br>
	
	<jsp:include page="footer.jsp">
		<jsp:param name="test" value="Bye"/>
	</jsp:include>
	
	
	
	
	
	
	
	
	
</body>
</html>