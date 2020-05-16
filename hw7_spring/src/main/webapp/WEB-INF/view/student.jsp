<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New product</title>
</head>
<body>

<c:url value="/students/edit" var="editUrl"/>
<form action="${editUrl}" method="post">
    <%-- Очень часто применяемый способ передачи id через форму --%>
    <input type="hidden" name="id" id="id" value="${student.id}">
    <p>
        <label for="name">Name</label>
        <input type="text" id="name" name="name" value="${student.name}" />
    </p>
    <p>
        <label for="mark">Mark</label>
        <input type="number" id="mark" name="mark" value="${student.mark}" />
    </p>
    <input type="submit" name="edit" value="Edit"/>
</form>

</body>
</html>
