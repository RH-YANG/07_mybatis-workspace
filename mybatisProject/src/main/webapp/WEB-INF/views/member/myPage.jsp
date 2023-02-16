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
	
	<div class="outer">
		<br><h1 align="center">마이페이지</h1><br>
		<form action="update.me" method="post">
         
         <table align="center">
                <tr>
                    <td>* ID</td>
                    <td><input type="text" name="userId" value="${ loginUser.userId }" readonly></td>
                </tr>
                <tr>
                    <td>* PWD</td>
                    <td><input type="password" name="userPwd" required value="${ loginUser.userPwd }"></td>
                </tr>
                <tr>
                    <td>* NAME</td>
                    <td><input type="text" name="userName" required value="${ loginUser.userName }"></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;EMAIL</td>
                    <td><input type="email" name="email" value="${ loginUser.email }"></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;BIRTHDAY</td>
                    <td><input type="text" name="birthday" placeholder="생년월일(6자리)" value="${ loginUser.birthday }"></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;GENDER</td>
                    <td align="center">
                        <input type="radio" name="gender" value="M"> 남
                        <input type="radio" name="gender" value="F"> 여
                    </td>
                    <script>
                    	document.querySelector("input[value=${loginUser.gender}]").checked = true;
                    </script>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;PHONE</td>
                    <td><input type="text" name="phone" placeholder="-포함" value="${ loginUser.phone }"></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;ADDRESS</td>
                    <td><input type="text" name="address" value="${ loginUser.address }"></td>
                </tr>
            </table>
            <br>
            <div align="center">
                <button type="reset">초기화</button>
                <button type="submit">정보변경</button>
            </div>
         
		</form><br><br>	
	
	</div>
	
	
</body>
</html>