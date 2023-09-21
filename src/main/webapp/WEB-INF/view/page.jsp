<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2023-09-15
  Time: 오전 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1"></table>
<c:forEach var="memo" items="${list}">
<tr>

    <td>${memo.mon}</td>
    <td>${memo.memoText}</td>

</tr>
</c:forEach>
</table>
</body>
</html>
