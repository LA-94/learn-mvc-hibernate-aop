<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Employee Editor</title>
</head>
<body>
<h2>Employee</h2>
<form:form action="saveEmployee" method="POST" modelAttribute="employee">
    <form:hidden path="id" id="superId"/>

    Name: <form:input path="name"/>
    <br>
    Surname: <form:input path="surname"/>
    <br>
    Department: <form:input path="department"/>
    <br>
    Salary: <form:input path="salary"/>
    <br>
    <br>
    <input type="submit" value="OK"/>
</form:form>
</body>
</html>