<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#list-area{
		border:1px solid white;
		text-align:center;
	}
	.outer a {
		color:white;
		text-decoration:none;
	}

</style>
	
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
    <div class="outer" align="center">
        <br><h1 align="center">게시판</h1><br>
        
        <div id="search-area">
            <form action="search.bo" method="get">
            	<input type="hidden" name="cpage" value="1">
                <select name="condition" >
                    <option value="writer">작성자</option>
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                </select>
                <input type="text" name="keyword" value="${ keyword }">
                <button type="submit">검색</button>
            </form>
        </div>
        <script>
        	document.querySelector("#search-area option[value=${condition}]").selected = true;
        </script>
        
        <c:if test="${ not empty loginUser }">
	        <div align="right" style="width:650px;">
	        	<button onclick="location.href='enrollForm.bo';">글작성</button>
	        </div>
        </c:if>
        <br>
        <table id="list-area">
            <thead>
                <tr>
                    <th>글번호</th>
                    <th width="400">제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody>
				<c:forEach var="b" items="${ list }">
                <tr>
                    <td>${ b.boardNo }</td>
                    <td><a href="detail.bo?no=${b.boardNo}">${ b.boardTitle }</a></td>
                    <td>${ b.boardWriter }</td>
                    <td>${ b.count }</td>
                    <td>${ b.createDate }</td>
                </tr>
				</c:forEach>
            </tbody>
        </table><br>

        <div id="paging-area">
        <c:choose>
        	<c:when test="${empty condition}">
				<c:if test="${pi.currentPage ne 1}"> <!-- 내가 보고있는 페이지가 1이 아닐경우 -->
	            <a href="list.bo?cpage=${pi.currentPage-1}">[이전]</a>
				</c:if>
				
				<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">	
		            <a href="list.bo?cpage=${p}">[${p}]</a>
	            </c:forEach>
	            
				<c:if test="${pi.currentPage ne pi.maxPage}"> <!-- 내가 보고있는 페이지가 마지막페이지가 아닐경우 -->
	            <a href="list.bo?cpage=${pi.currentPage+1}">[다음]</a>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${ pi.currentPage ne 1 }"> <!-- 내가 보고있는 페이지가 1이 아닐경우 -->
	            <a href="search.bo?cpage=${pi.currentPage-1}&condition=${condition}&keyword=${keyword}">[이전]</a>
				</c:if>
				
				<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">	
		            <a href="search.bo?cpage=${p}&condition=${condition}&keyword=${keyword}">[${ p }]</a>
	            </c:forEach>
	            
				<c:if test="${pi.currentPage ne pi.maxPage}"> <!-- 내가 보고있는 페이지가 마지막페이지가 아닐경우 -->
	            <a href="search.bo?cpage=${pi.currentPage+1}&condition=${condition}&keyword=${keyword}">[다음]</a>
				</c:if>
	        </c:otherwise>
		</c:choose>	
        </div><br><br>

    </div>
	

</body>
</html>