<%@ page import="com.koreait.mvc2.dto.PostDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2025-06-13
  Time: 오후 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    com.koreait.mvc2.dto.MemberDTO user = (com.koreait.mvc2.dto.MemberDTO) session.getAttribute("user");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
</head>
<body>
<p><a href="mypage.member">마이페이지</a> | <a href="login.member">로그인</a> | <a href="logout.member">로그아웃</a> | <a
        href="board.post">게시판</a></p>
<h2>게시판 목록</h2>
<p>게시물을 확인해보세요</p>
<form method="get" action="write.post">
    <button type="submit">게시물 작성하러 가기</button>
</form>
<div>
    <%@ include file="/WEB-INF/views/messageBox.jsp" %>
</div>
<table border="1">
    <tr>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
        <th>댓글수</th>
    </tr>
    <c:forEach var="post" items="${posts}">
        <tr>
            <td><a href="view.post?idx=${post.idx}">${post.title}</a></td>
                <%--              <td>${post.user_id}</td>--%>
            <td>${post.user_id}</td>
            <td>${post.regdate}</td>
            <td>${post.view_count}</td>
            <td>${post.comment_count}</td>

        </tr>
    </c:forEach>
</table>

<script>
    const currentUserId = '${user.userid}';
    function openMessageBox(userId) {
        document.getElementById("receiverIdInput").value = userId;
        document.getElementById("senderIdInput").value = currentUserId;
        document.getElementById("messageBox").style.display = "block";
    }
</script>
</body>
</html>
