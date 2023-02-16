<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL Functions Library</h1>
	
	<c:set var="str" value="How Are You?" />
	
	str : ${ str } <br>
	
	문자열의 길이 : ${ str.length() } <br>
	문자열의 길이 : ${ fn:length(str) } <br><br> <!-- arrayList또는 배열 제시가능함 => 리스트 또는 배열의 사이즈 -->
	
	모두 대문자로 출력 : ${ str.toUpperCase() } <br>
	모두 대문자로 출력 : ${ fn:toUpperCase(str) } <br>
	모두 소문자로 출력 : ${ fn:toLowerCase(str) } <br><br>
	
	Are의 시작인덱스 : ${ str.indexOf('Are') } <br>
	Are의 시작인덱스 : ${ fn:indexOf(str, "Are") } <br><br>
	
	Are => Were 변경 : ${ fn:replace(str, "Are", "Were") } <br><br>
	
	문자열 추출 : ${ fn:substring(str, 1, 5) } <br><br>
	
	<c:if test="${ fn:contains(str, 'are') }">
		are이 포함되어있음 <br>
	</c:if>
	
	<c:if test="${ fn:containsIgnoreCase(str, 'are') }">
		대소문자 가리지 않고 are이 포함되어있음 <br>
	</c:if>
	
	
	
	
	
	
</body>
</html>