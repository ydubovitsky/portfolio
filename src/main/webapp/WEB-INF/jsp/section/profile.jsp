<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-4">
            <tags:profile-photo/>
            <tags:profile-lang/>
            <tags:profile-hobby/>
            <tags:profile-info/>
        </div>
        <div class="col-md-8">
            <tags:profile-objective/>
            <tags:profile-practice/>
            <tags:profile-certificate/>
            <tags:profile-experience/>
            <tags:profile-education/>
        </div>
    </div>
</div>
</body>
