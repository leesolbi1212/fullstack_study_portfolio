<%--
  Created by IntelliJ IDEA.
  User: dmddn
  Date: 25. 6. 5.
  Time: 오전 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//  String userid = (String) session.getAttribute("userid");
  String userid = request.getParameter("userid");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>전달받은 userid : <%=userid%></p>
</body>
</html>
