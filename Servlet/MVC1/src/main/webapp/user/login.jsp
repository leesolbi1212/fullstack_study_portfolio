<%--
  Created by IntelliJ IDEA.
  User: dmddn
  Date: 2025-06-11
  Time: 오전 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h2>로그인</h2>
<form method ="post" action="result.jsp">
  <%-- result로 가서 join에서 왔어! 라는 걸 알려주려고 하는 것. 로그인페이지에서는 value = login 이라고 쓸 겨 --%>
  <input type="hidden" name="action" value="login">
  <p>아이디 : <input type="text" name="userid"></p>
  <p>비밀번호 : <input type="password" name="userpw"></p>
  <p><button type="submit">완료</button> </p>
</form>
</body>
</html>