<%--
  Created by IntelliJ IDEA.
  User: dmddn
  Date: 25. 6. 4.
  Time: 오후 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 쿠키는 여러 개 일수 있기 때문에 무조건 배열로 가져옴
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();
            if(cookieName.equals("userid")) {
                String cookieValue = cookie.getValue();
                out.print("userid 쿠키 값 : " + cookieValue);
            }
        }
    } else {
        out.print("쿠키 No 존재");
    }
%>
<html>
<head>
    <title>cookie</title>
</head>
<body>
<h2>꾸끼 가져오기</h2>
</body>
</html>
