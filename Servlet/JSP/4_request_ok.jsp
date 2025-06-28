<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 25. 6. 4.
  Time: 오전 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userid = request.getParameter("userid");
    String userpw = request.getParameter("userpw");
//  hobby는 복수값이므로 배열로 받아야 함
    String[] hobby = request.getParameterValues("hobby");
%>
<html>
<head>
    <title>request 받는 페이지</title>
</head>
<body>
<p>아이디 :<%=userid%></p>
<p>비밀번호 :<%=userpw%></p>
<p>취미: <%=Arrays.toString(hobby)%></p>
</body>
</html>
