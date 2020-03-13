<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-4 col-sm-6">
            <tags:profile-main />
            <div class="hidden-xs">
                <tags:profile-languages />
                <tags:profile-hobbies />
                <tags:profile-info />
            </div>
        </div>
        <div class="col-md-8 col-sm-6">
            <tags:profile-objective/>
            <tags:profile-skills />
            <tags:profile-practics />
            <tags:profile-certificates/>
            <tags:profile-cources/>
        </div>
        <div class="col-xs-12 visible-xs-block">
            <tags:profile-languages />
            <tags:profile-hobbies />
            <tags:profile-info />
        </div>
    </div>
</div>
</body>
