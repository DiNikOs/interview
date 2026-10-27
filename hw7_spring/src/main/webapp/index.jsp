<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <ul>
        <c:url value="/students/" var="studentsUrl" />
        <li><a href="${studentsUrl}">Students</a></li>

    </ul>
</body>
</html>
