<%--
  Created by IntelliJ IDEA.
  User: dmddn
  Date: 25. 6. 5.
  Time: 오후 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userid  = (String)request.getAttribute("userid");
    String name = (String)request.getAttribute("name");
    String gender = (String)request.getAttribute("gender");
    int age = (Integer)request.getAttribute("age");

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>포워드로 넘어온 값 </h2>
<p>user id : <%=userid%> </p>
<p>name : <%=name%> </p>
<p>gender : <%=gender%> </p>
<p>age : <%=age%> </p>

</body>
</html>
