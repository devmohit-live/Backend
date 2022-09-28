	<%@ include file="common/header.jspf"%>
	<%@ include file="common/navbar.jspf"%>
	<div class="container-fluid">
		<p>Welcome to web ${username}</p>
		<p>Your password is ${password}</p>
		<div>
			<a href="list-todos">Manage Todos</a>
		</div>
	</div>
	<%@ include file="common/footer.jspf"%>