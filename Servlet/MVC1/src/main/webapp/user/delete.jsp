
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.koreait.mvc1.data.MemberDTO, com.koreait.mvc1.data.MemberDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setCharacterEncoding("UTF-8");
    // 세션에서 현재 로그인된 사용자의 아이디 가져오기
    MemberDTO loginUser = (MemberDTO) session.getAttribute("user");
    MemberDAO dao = new MemberDAO();
    MemberDTO member = dao.getMemberById(loginUser.getUserid());

    // 세션에서 userid가 없으면 (즉, 로그인 안 한 상태라면) 로그인 페이지로 이동
    if(loginUser == null) {
        response.sendRedirect("login.jsp");
        return;
    } else if (member == null){
        response.sendRedirect("login.jsp");
        return;
    }

    // DAO를 통해 DB에서 회원 정보를 삭제 (탈퇴 처리)
    boolean success = dao.deleteMember(loginUser.getUserid());

    if(success) {
        session.invalidate(); // 탈퇴 성공하면 세션 초기화 (로그아웃 처리)
%>
<script>
    alert('회원 탈퇴가 완료되었습니다.');
    location.href = 'login.jsp'; // 로그인 페이지로 이동
</script>
<%
} else {
%>
<script>
    alert('회원 탈퇴에 실패했습니다. 다시 시도해 주세요.');
    location.href = 'info.jsp'; // 다시 info.jsp로 이동
</script>
<%
    }
%>

<html>
<head>
    <title>회원 탈퇴</title>
</head>
<body>

</body>
</html>
