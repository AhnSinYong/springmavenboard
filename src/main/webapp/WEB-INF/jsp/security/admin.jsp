<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Title:${title}</h1>
    <h1>Message:${message}</h1>

    <form action="/logout" method="post" id="logoutForm">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome : ${pageContext.request.userPrincipal.name} |
            <a href="javascript:formSubmit()">Logout</a>
        </h2>
    </c:if>
</body>
</html>
