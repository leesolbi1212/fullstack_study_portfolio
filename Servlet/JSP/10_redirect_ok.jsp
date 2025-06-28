<%--
  Created by IntelliJ IDEA.
  User: dmddn
  Date: 25. 6. 5.
  Time: 오전 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userid = request.getParameter("userid");
    %>
<%--    session.setAttribute("userid", userid);--%>
<%--    response.sendRedirect("10_redirect_result.jsp");--%>

<html>
<head>
    <title>Title</title>
    <script>
        window.onload = function () {
            document.getElementById("hiddenValue").value = "<%= userid %>"
            document.getElementById("redirectForm").submit();
        }
    </script>
</head>
<body>
<form id="redirectForm" method="post" action="10_redirect_result.jsp">
    <input type="hidden" id="hiddenValue" name="userid" value="">
</form>
</body>
</html>
