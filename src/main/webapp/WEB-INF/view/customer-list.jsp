<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 25.08.2020
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html>
    <head>
        <title>CRM</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    </head>
    <body>
        <div class="wrapper">
            <div class="header_container">
                <h1 class="header_text_style">CRM - Customer Relationship Manager</h1>
            </div>
        </div>

        <div class="container">
            <a class="button_add" href="create" >
                <button>Add customer</button>
            </a>
            <div class="content">
                <table>
                    <tr class="table_main_color">
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="customer" items="${customers}">

                        <c:url var="updateLink" value="/customer/update">
                            <c:param name="customerId" value="${customer.id}"/>
                        </c:url>

                        <c:url var="deleteLink" value="/customer/delete">
                            <c:param name="customerId" value="${customer.id}"/>
                        </c:url>
                        <tr>
                            <td>${customer.first_name}</td>
                            <td>${customer.last_name}</td>
                            <td>${customer.email}</td>
                            <td><a href="${updateLink}">Update</a> ||
                                <a href="${deleteLink}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>