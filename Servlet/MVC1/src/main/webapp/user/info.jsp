
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.koreait.mvc1.data.MemberDTO, com.koreait.mvc1.data.MemberDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setCharacterEncoding("UTF-8");
    // 세션에서 현재 로그인된 사용자의 아이디 가져오기
    MemberDTO loginUser = (MemberDTO) session.getAttribute("user");
    MemberDAO dao = new MemberDAO();
    MemberDTO member = dao.getMemberById(loginUser.getUserid());

    // 세션에서 userid가 없으면 로그인 페이지로 이동
    if(loginUser == null) {
        response.sendRedirect("login.jsp");
        return;
    } else if (member == null){
        response.sendRedirect("login.jsp");
        return;
}
%>
<html>
<head>
    <title>회원정보 수정</title>
</head>
<body>
<h2>회원 정보 수정 페이지 </h2>
<%--수정한 데이터는 result로 전달되어 DB에 반영하는 로직을 처리하게 된다. --%>
<form method ="post" action="result.jsp">
    <%-- result로 가서 join에서 왔어! 라는 걸 알려주려고 하는 것. 로그인페이지에서는 value = login 이라고 쓸 겨 --%>
    <input type="hidden" name="action" value="info">
    <p>아이디 : <input type="text" name="userid" value="<%=member.getUserid()%>" readonly></p>
    <p>비밀번호 : <input type="password" name="userpw" value="<%=member.getUserpw()%>"></p>
    <p>이름 : <input type="text" name="name" value="<%=member.getName()%>"></p>
    <p>휴대폰 : <input type="text" name="hp" value="<%=member.getHp()%>"></p>
    <p>이메일 : <input type="email" name="email" value="<%=member.getEmail()%>"></p>
    <p>성별 : <select name="gender">
        <option value="남자">남자</option>
        <option value="여자">여자</option>
    </select></p>
    <p>주민등록번호 : <input type="text" name="ssn1" value="<%=member.getSsn1()%>"> - <input type="password" name="ssn2" value="<%=member.getSsn2()%>"> </p>
    <p>우편번호 : <input type="text" name="zipcode" value="<%=member.getZipcode()%>"></p>
    <p>주소 : <input type="text" name="address1" value="<%=member.getAddress1()%>"></p>
    <p>상세주소 : <input type="text" name="address2" value="<%=member.getAddress1()%>"></p>
    <p>참고항목 : <input type="text" name="address3" value="<%=member.getAddress1()%>"></p>
    <p><button type="submit">수정 완료</button> </p>
</form>
</body>
</html>
