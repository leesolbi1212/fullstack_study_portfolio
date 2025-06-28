<%--
  Created by IntelliJ IDEA.
  User: dmddn
  Date: 25. 6. 5.
  Time: 오전 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--세션이 있는지 없는지 먼저 판단하기 : URL 입력하고 바로 들어오면 안되기 때문--%>
<%
  if(session.getAttribute("userid")==null) {
    response.sendRedirect("7_session.jsp");
  }
  String userid = (String)session.getAttribute("userid");
%>
<html>
<head>
    <title>session</title>
</head>
<body>
<h2>로그인 성공</h2>
<p><%=userid%>님 로그인되었습니다. 츄카포카~!</p>
<p>[<a href="7_session_logout.jsp">로그아웃</a>]</p>
</body>
</html>
