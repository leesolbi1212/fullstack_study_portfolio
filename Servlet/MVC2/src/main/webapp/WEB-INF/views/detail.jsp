<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2025-06-13
  Time: 오후 3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    com.koreait.mvc2.dto.MemberDTO user = (com.koreait.mvc2.dto.MemberDTO) session.getAttribute("user");
%>
<html>
<head>
    <title>게시물 상세페이지</title>
</head>
<style>
    .author:hover {
        color: deeppink;
        font-weight: bold;
    }
    #help {
        position: absolute;
        background: #fff;
        border: 1px solid #ccc;
        padding: 10px;
    }

</style>
<body>
<p><a href="mypage.member">마이페이지</a> | <a href="login.member">로그인</a> | <a href="logout.member">로그아웃</a> | <a href="board.post">게시판</a></p>
<h2>제목: ${onePost.title}</h2>
<div id="help" style="display:none;">
    <p>아이디를 클릭하면 쪽지를 보낼 수 있어요.</p>
</div>
<p>작성자:  <span class="author" onclick="${onePost.user_id != user.userid? 'toggleMessageForm()':""}" style="cursor: pointer;"> ${onePost.user_id} </span>
</p>
<c:if test="${onePost.user_id ne user.userid}">
    <form id="msgForm" action="write.message" method="get" style="display:none;">
        <input type="hidden" name="receiver" value="${onePost.user_id}">
        <button type="submit">쪽지 보내기</button>
    </form>
</c:if>
<p>작성일: ${onePost.regdate}</p>
<p>조회수: ${onePost.view_count}</p>
<p>${onePost.content}</p>
<c:choose>
    <c:when test="${onePost.user_id eq user.userid}">
        <a href="edit.post?idx=${onePost.idx}"><button type="submit">수정하기</button></a>
        <form method="post" action="delete.post" onsubmit="return confirm('정말 삭제하시겠습니까?')">
            <input type="hidden" name="idx" value="${onePost.idx}">
            <button type="submit">삭제하기</button>
        </form>
    </c:when>
</c:choose>
<p><a href="board.post">게시판으로 돌아가기</a></p>

<br>
<hr>
<%--댓글 쓰는 란--%>
<button type="button" onclick="showComment()">댓글 보기(${commentCount})</button>
<div id="commentBox" style="display: none;">
<h3>댓글</h3>
<form method="post" action="comment.post">
    <input type="hidden" name="board_idx" value="${onePost.idx}">
    <p>댓글 쓰기: <textarea name="comment" placeholder="댓글을 작성해보세요"></textarea></p>
    <button type="submit">작성</button>
</form>
<hr>
<%--댓글 보이는 란--%>
<c:forEach var="comment" items="${comments}" varStatus="status">

    <p>작성자:<span class="author"
                 onclick="toggleCommentForm(${status.index})"
                 style="cursor: ${comment.user_id != user.userid ? 'pointer' : 'default'};">
            ${comment.user_id}
    </span></p>
    <c:if test="${comment.user_id ne user.userid}">
        <form id="msgForm-${status.index}" action="write.message" method="get" style="display: none;">
            <input type="hidden" name="receiver" value="${comment.user_id}">
            <button type="submit">쪽지 보내기</button>
        </form>
    </c:if>
    <p>작성일:${comment.regdate}</p>
    <p>내용:${comment.content}</p>
    <c:choose>
        <c:when test="${comment.user_id eq user.userid}">
            <form method="get" action="editComment.post">
                <input type="hidden" name="comment_idx" value="${comment.idx}">
                <input type="hidden" name="board_idx" value="${onePost.idx}">
                <button type="submit">수정하기</button>
            </form>
            <form method="post" action="deleteComment.post" onsubmit="return confirm('정말 삭제하시겠습니까?')">
                <input type="hidden" name="comment_idx" value="${comment.idx}">
                <input type="hidden" name="board_idx" value="${onePost.idx}">
                <button type="submit">삭제하기</button>
            </form>
        </c:when>
    </c:choose>
    <button type="button" onclick="showRecomment(${status.index})">대댓글 보기</button>
    <div id="reCommentBox-${status.index}" style="display: none;">
        <form method="post" action="reComment.post">
            <input type="hidden" name="comment_idx" value="${comment.idx}">
            <textarea name="recontent" placeholder="대댓글을 입력하세요"></textarea><br>
            <button type="submit">대댓글 달기</button>
        </form>
    </div>
    <hr>
</c:forEach>
</div>
<script>
    function showComment() {
        const box = document.getElementById("commentBox");
        if (box.style.display === "none") {
            box.style.display = "block";
        } else {
            box.style.display = "none";
        }
    }

    function showRecomment(index) {
        const box = document.getElementById("reCommentBox-" + index);
        if (box.style.display === "none") {
            box.style.display = "block";
        } else {
            box.style.display = "none";
        }
    }

    function toggleMessageForm() {
        const form = document.getElementById("msgForm");
        form.style.display = form.style.display === "none" ? "block" : "none";

    }

    function toggleCommentForm(index) {
        const form = document.getElementById("msgForm-" + index);
        if (form) {
            form.style.display = form.style.display === "none" ? "block" : "none";
        }
    }

    const author = document.querySelector('.author');
    const help = document.getElementById('help');

    author.addEventListener('mouseenter', () => {
        help.style.display = 'block';
        // 필요 시 위치 조정
        const rect = author.getBoundingClientRect();
        help.style.top = (rect.bottom + window.scrollY) + 'px';
        help.style.left = (rect.left + window.scrollX) + 'px';
    });

    author.addEventListener('mouseleave', () => {
        help.style.display = 'none';
    });

</script>
</body>
</html>
