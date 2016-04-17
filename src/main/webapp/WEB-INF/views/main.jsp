<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

</head>

<body>
<div class="container">
    <jsp:include page="header.jsp"/>


    <!-- Main  -->

    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Books </span></div>


        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Patronymic</th>
                    <th>mob_phone</th>
                    <th>home_phone</th>
                    <th>address</th>
                    <th>email</th>
                    <th width="100"></th>
                    <th width="100"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${phoneBookItems}" var="phoneBookItem">
                    <tr>
                        <td>${phoneBookItem.id}</td>
                        <td>${phoneBookItem.name}</td>
                        <td>${phoneBookItem.surname}</td>
                        <td>${phoneBookItem.patronymic}</td>
                        <td>${phoneBookItem.mobPhone}</td>
                        <td>${phoneBookItem.homePhone}</td>
                        <td>${phoneBookItem.address}</td>
                        <td>${phoneBookItem.email}</td>
                        <td><a href="<c:url value='/edit-phoneBook-${phoneBookItem.id}' />"
                               class="btn btn-success custom-width">EDIT</a>
                        </td>
                        <td><a href="<c:url value='/delete-phoneBook-${phoneBookItem.id}' />"
                               class="btn btn-danger ">DELETE</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<%--<div class="well">--%>
<%--<a href="<c:url value='/addbook' />">Add New User</a>--%>
<%--</div>--%>

</div>
<!-- /container -->


</body>
</html>