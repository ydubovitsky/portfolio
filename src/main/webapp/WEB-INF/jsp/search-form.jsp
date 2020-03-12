<%@ page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    LoggerFactory.getLogger("search-form.jsp").debug("Display search from");
%>
<html>
    <body>
        <h2>Input Name:</h2>
        <c:if test="${invalid}">
            <h5 style="color:red">Please insert correct value</h5>
        </c:if>
        <form action="/search" method="post">
            <input name="name">
            <input type="submit" value="search">
        </form>
    </body>
</html>