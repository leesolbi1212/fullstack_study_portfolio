<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2025-06-17
  Time: 오전 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>글 수정</h2>
<form method="post" action="editForm.board">
    <input type="hidden" name="idx" value="${board.idx}">
    <p>제목: <input type="text" name="title" value="${board.title}"></p>
    <p>내용: <textarea name="content" rows="5" cols="50">${board.content}</textarea></p>
    <p>
        <button type="submit">수정하기</button>
    </p>
    <p><a href="list.board">목록</a></p>
</form>
</body>
</html>
