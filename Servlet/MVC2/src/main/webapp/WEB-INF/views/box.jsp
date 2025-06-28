<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2025-06-16
  Time: 오후 3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  com.koreait.mvc2.dto.MemberDTO user = (com.koreait.mvc2.dto.MemberDTO) session.getAttribute("user");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="mypage.member">마이페이지</a> | <a href="logout.member">로그아웃</a> | <a href="board.post">게시판</a></p>
<h1> 받은 쪽지</h1>

<c:choose>
  <c:when test="${empty inbox}">
    <p>받은 쪽지가 없습니다.</p>
  </c:when>
  <c:otherwise>
    <c:forEach var="msg" items="${inbox}">
      <c:if test="${!msg.deletedByReceiver}">
        <p>From: ${msg.senderID} - ${msg.sendDate}<br>
            ${msg.content}</p>

        <form method="post" action="delete.message" onsubmit="return confirm('정말 삭제하시겠습니까?')">
          <input type="hidden" name="messageID" value="${msg.messageID}">
          <input type="hidden" name="type" value="receiver">
          <button type="submit">삭제</button>
        </form>
        <hr>
      </c:if>
    </c:forEach>
  </c:otherwise>
</c:choose>

<h1> 보낸 쪽지</h1>

<c:choose>
  <c:when test="${empty outbox}">
    <p>보낸 쪽지가 없습니다.</p>
  </c:when>
  <c:otherwise>
    <c:forEach var="msg" items="${outbox}">
      <c:if test="${!msg.deletedBySender}">
        <p>To: ${msg.receiverID} - ${msg.sendDate}<br>
            ${msg.content}</p>

        <form method="post" action="delete.message" onsubmit="return confirm('정말 삭제하시겠습니까?')">
          <input type="hidden" name="messageID" value="${msg.messageID}">
          <input type="hidden" name="type" value="sender">
          <button type="submit">삭제</button>
        </form>
        <hr>
      </c:if>
    </c:forEach>
  </c:otherwise>
</c:choose>

</body>
</html>
