<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2025-06-12
  Time: 오후 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  com.koreait.mvc2.dto.MemberDTO user = (com.koreait.mvc2.dto.MemberDTO) session.getAttribute("user");
%>
<html>
<head>
    <title>edit</title>
</head>
<body>
<p><a href="mypage.member">마이페이지</a> | <a href="logout.member">로그아웃</a> | <a href="board.post">게시판</a></p>
<h2>회원정보 수정</h2>
<form method="post" action="modifyForm.member">
  <p>아이디: ${user.userid}</p>
  <p>이름: <input type="text" name="name" value="${user.name}" ></p>
  <p>휴대폰: <input type="text" name="hp" value="${user.hp}" ></p>
  <p>이메일: <input type="email" name="email" value="${user.email}" ></p>
  <p>성별: <select name="gender">
    <option ${user.gender =="남자" ? "selected" : ""} value="남자">남자</option>
    <option ${user.gender =="여자" ? "selected" : ""} value="여자">여자</option>
  </select></p>
  <p>우편번호: <input type="text" name="zipcode" value="${user.zipcode}"  ></p>
  <p>주소: <input type="text" name="address1" value="${user.address1}" ></p>
  <p>상세주소: <input type="text" name="address2" value="${user.address2}" ></p>
  <p>참고항목: <input type="text" name="address3" value="${user.address3}" ></p>
  <p><button type="submit">완료</button></p>

</form>
</body>
</html>
