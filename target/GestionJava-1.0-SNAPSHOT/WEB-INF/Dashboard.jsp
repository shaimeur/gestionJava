<%@ page import="java.util.List" %>
<%@ page import="com.shaimeur.entities.Employee" %><%--
  Created by IntelliJ IDEA.
  User: haime
  Date: 1/18/2022
  Time: 2:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Dashboard</title>
</head>

<body>

<h2>All Employee
    <a href="${pageContext.servletContext.contextPath}/AddEmployee">Add new Employee </a>
</h2>
<table>
    <thead>
    <tr>
        <td>id</td>
        <td>email</td>
        <td>firstname</td>
        <td>lastname</td>
    </tr>
    </thead>
    <tbody>
    <%List<Employee> employees = (List<Employee>) request.getAttribute("employees");

        for(int i = 0 ;i < employees.size() ; i++ ) {%>
    <tr>
        <td><% out.println(employees.get(i).getId());  %></td>
        <td><% out.println(employees.get(i).getEmail());%></td>
        <td><% out.println(employees.get(i).getFirstName());%></td>
        <td><% out.println(employees.get(i).getLastName());%></td>
        <td>
            <a href="${pageContext.servletContext.contextPath}/UpdateEmployee">Update  Employee </a>
            <a href="${pageContext.servletContext.contextPath}/DeleteEmployee">Delete Employee </a>
        </td>


    </tr>
    <%}%>
    </tbody>


</table>



</body>
</html>