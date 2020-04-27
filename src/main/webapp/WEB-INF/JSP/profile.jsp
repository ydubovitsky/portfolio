<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<div class="container">
	<div class="row">
		<div class="col-md-4 col-sm-6">
			<tg:profile-main />
			<div class="hidden-xs">
				<tg:profile-languages />
				<tg:profile-hobbies />
				<tg:profile-info />
			</div>
		</div>
		<div class="col-md-8 col-sm-6">
			<tg:profile-objective/>
			<tg:profile-skills />
			<tg:profile-practics />
			<tg:profile-certificates/>
			<tg:profile-cources/>
			<tg:profile-education />
		</div>
		<div class="col-xs-12 visible-xs-block">
			<tg:profile-languages />
			<tg:profile-hobbies />
			<tg:profile-info />
		</div>
	</div>
</div>