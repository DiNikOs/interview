<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New student</title>
</head>
<body>

<c:url value="/students/edit" var="editUrl"/>
<form action="${editUrl}" method="post">
    <%-- --%>
    <input type="hidden" name="id" id="id" value="${student.id}">
    <p>
        <label for="name">Name</label>
        <input type="text" id="name" name="name" value="${student.name}" />
    </p>
    <p>
        <label for="age">Age</label>
        <input type="number" id="age" name="age" value="${student.age}" />
    </p>
    <input type="submit" name="edit" value="Edit"/>
</form>

</body>
</html>
