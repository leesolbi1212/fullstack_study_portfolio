<%--
  Created by IntelliJ IDEA.
  User: dmddn
  Date: 25. 6. 5.
  Time: 오전 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="9_errorpage_error.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>errorpage</h2>
<p>에러 발생했슈~</p>
<%
  String abc = (String)session.getAttribute("ABC");
  abc.charAt(3); //에러 발생시키기!
%>
</body>
</html>
