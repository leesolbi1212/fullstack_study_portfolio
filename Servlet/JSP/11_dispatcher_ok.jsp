<%--
  Created by IntelliJ IDEA.
  User: dmddn
  Date: 25. 6. 5.
  Time: 오후 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String userid = request.getParameter("userid");
  request.setAttribute("userid", userid);
  request.setAttribute("name","김사과");
  request.setAttribute("age",20);
  request.setAttribute("gender","여자");

  RequestDispatcher rd = request.getRequestDispatcher("11_dispatcher_result.jsp");
  rd.forward(request, response);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
