<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2025-06-16
  Time: 오후 3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  com.koreait.mvc2.dto.MemberDTO user = (com.koreait.mvc2.dto.MemberDTO) session.getAttribute("user");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  String error = (String) request.getAttribute("error");
  if (error != null) {
%>
<script>
  alert("<%= error %>");
</script>
<%
  }
%>
<h2>쪽지 보내기</h2>
<form action="send.message" method="post">
  <input type="hidden" name="sender" value="<%= user.getUserid() %>">
  <p>받는 사람 ID: <input type="text" name="receiver" value="${receiver}" readonly><br><br></p>
  <p>내용:<br>
    <textarea name="content" rows="5" cols="50"></textarea><br><br></p>
  <p><button type="submit">작성</button></p>
</form>
</body>
</html>
