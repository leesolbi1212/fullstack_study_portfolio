<%--
  Created by IntelliJ IDEA.
  User: dmddn
  Date: 25. 6. 5.
  Time: 오전 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userid = request.getParameter("userid");
    String userpw = request.getParameter("userpw");
//    클라이언트에서 넘어온 괄호 안에 있는 userid = name과 일치히야함
    if (userid.equals("admin")&&userpw.equals("1234")) {
        session.setAttribute("userid", userid);
        response.sendRedirect("7_session_success.jsp");
    } else {
        response.sendRedirect("7_session_fail.jsp");
    }
%>
<html>
<head>
    <title>session</title>
</head>
<body>

</body>
</html>
