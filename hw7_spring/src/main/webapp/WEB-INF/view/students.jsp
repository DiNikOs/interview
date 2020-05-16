<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Students</title>
</head>
<body>

<c:url value="/students/create" var="createStudentUrl" />
<form action="${createStudentUrl}" method="post">
    <%-- --%>
    <input  name="id" id="id" value="${student.id}" type="hidden">
    <%-- --%>
    <p>
        <label for="name">Name</label>
        <input type="text" id="name" name="name" value="${student.name}" />
    </p>
    <p>
        <label for="age">Age</label>
        <input type="text" id="age" name="age" value="${student.age}" />
    </p>
    <input id="add" type="submit" name="add" value="Sava"/>
</form>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Age</th>
    </tr>

    <c:forEach items="${students}" var="student">
        <tr>

            <c:url value="/students/edit" var="editProductUrl">
                <c:param name="id" value="${student.id}"/>
            </c:url>
            <td>${student.name}</td>
            <td>${student.age}</td>

            <td>
                <c:url value="/students/edit" var="editStudentUrl" />
                <form action="${editStudentUrl}" method="post">
                        <%-- --%>
                    <input  name="id" id="id" value="${student.id}" type="hidden">
                    <input type="submit" name="edit" value="Edit"/>
                </form>
            </td>
            <td>
                <c:url value="/students/delete" var="deleteStudentUrl" />
                <form action="${deleteStudentUrl}" method="post">
                        <%--  --%>
                    <input  name="id" id="id" value="${student.id}" type="hidden">
                    <input type="submit" name="delete" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
