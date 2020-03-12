<%@ page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    LoggerFactory.getLogger("search-result.jsp").debug("search-result.jsp");
%>

<html>
    <body>
        <h2>Hello ${result}</h2>
        <h4><a href="/search">return on the search page</a></h4>
    </body>
</html>