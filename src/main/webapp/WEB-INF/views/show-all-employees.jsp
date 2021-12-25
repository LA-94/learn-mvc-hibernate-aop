<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Employee</title>
</head>
<body>

<h2>All Employees</h2>

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employees}">
        <c:url var="updateButton" value="/updateEmployee">
            <c:param name="id" value="${employee.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="id" value="${employee.id}"/>
        </c:url>

        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.department}</td>
            <td>${employee.salary}</td>
            <td>
                <button onclick="window.location.href='${updateButton}'">Update</button>
                <button onclick="window.location.href='${deleteButton}'">Delete</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<button onclick="window.location.href='addEmployee';">Add</button>
</body>
</html>