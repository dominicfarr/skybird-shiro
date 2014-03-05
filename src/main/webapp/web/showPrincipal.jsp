<%@ page import="org.apache.shiro.subject.support.DefaultSubjectContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Principal</title>
</head>
<body>
    Grab the principal from session: <%=request.getSession(false).getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)%>
</body>
</html>