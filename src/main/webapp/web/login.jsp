<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Log In</h2>

<form name="loginform" action="" method="post">
    <div><label for="username">Username:</label><input name="username" id="username" value="<c:out value="${username}" />"></div>
    <div><label for="password">Password:</label><input name="password" id="password"></div>
    <div><input type="checkbox" name="rememberMe" value="true"/>Remember Me?</div>
    <input type="submit" />
</form>
<c:if test="${not empty shiroLoginFailure}">
    Bad credentials
</c:if>
</body>
</html>
