<%--
  Created by IntelliJ IDEA.
  User: dmddn
  Date: 25. 6. 5.
  Time: 오전 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  session.invalidate(); // session 삭제하는 법
  response.sendRedirect("7_session.jsp");
%>
<html>
<head>
    <title>session</title>
</head>
<body>

</body>
</html>
