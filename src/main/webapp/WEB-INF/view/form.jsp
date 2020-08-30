<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 26.08.2020
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
    <div>
        <div class="wrapper">
            <div class="header_container">
                <h1 class="header_text_style">Create customer</h1>
            </div>
        </div>

        <h2 class = "save_customer">Save customer</h2>
        <div class="create_form">
                <form:form action="create" modelAttribute="customer" method="post">

                    <form:hidden path="id"/>

                    First name: <form:input path="first_name" />
                    <br><br>
                    Last name: <form:input path="last_name" />
                    <br><br>
                    Email: <form:input path="email" />
                    <br><br>
                    <input type="submit" value="Register" style="margin-left: 5%;">
                </form:form>
        </div>

        <a href="list">Back to main</a>
    </div>

</body>
</html>
