<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<div class="panel panel-primary">
	<a href="/edit"><img class="img-responsive photo" src="${profile.targetPhoto}" alt="photo"></a>
	<h1 class="text-center">
		<a style="color: black;" href="/edit">${profile != null ? profile.getFullName() : 'Unknown Unknown' }</a>
	</h1>
	<h6 class="text-center">
		<strong>${profile.city}</strong>
	</h6>
	<h6 class="text-center">
		<strong>Age:</strong> 27, <strong>Birthday: </strong> Feb 26, 1989
	</h6>
	<div class="list-group contacts">
		<a class="list-group-item" href="tel:+380507525137"><i class="fa fa-phone"></i>${profile.phone}</a>
		<a class="list-group-item" href="mailto:unknown@gmail.com"><i class="fa fa-envelope"></i>${profile.email}</a>
		<a class="list-group-item" href="javascript:void(0);"><i class="fa fa-skype"></i>${profile.contacts.skype}</a>
		<a target="_blank" class="list-group-item" href="https://vk.com/unknown"><i class="fa fa-vk"></i> ${profile.contacts.vkontakte}</a>
		<a target="_blank" class="list-group-item" href="https://facebook.com/unknown"><i class="fa fa-facebook"></i> ${profile.contacts.facebook}</a>
		<a target="_blank" class="list-group-item" href="https://linkedin.com/unknown"><i class="fa fa-linkedin"></i> ${profile.contacts.linkedin}</a>
		<a target="_blank" class="list-group-item" href="https://github.com/unknown"><i class="fa fa-github"></i> ${profile.contacts.github}</a>
		<a target="_blank" class="list-group-item" href="https://stackoverflow.com/unknown"><i class="fa fa-stack-overflow"></i> ${profile.contacts.stackoverflow}</a>
	</div>
</div>