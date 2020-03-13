<%@ page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <jsp:include page="../section/css.jsp"/>
    <!--FIXME Добавить FontsAwesome-->
    <title>Portfolio</title>
</head>
    <body class="resume">
    <jsp:include page="../section/header.jsp"/>
    <jsp:include page="../section/nav.jsp"/>
    <section class="main">
        <sitemesh:write property='body'/>
    </section>
    <jsp:include page="../section/footer.jsp"/>
    <jsp:include page="../section/js.jsp"/>
    </body>
</html>