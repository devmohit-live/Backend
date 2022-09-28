	<%@ include file="common/header.jspf"%>
	<%@ include file="common/navbar.jspf"%>
	<h2>Login Page</h2>
	<div class="container">
		<span class="text text-danger">${error}</span>
		<form method="post">
			Name : <input type="text" name="username" /> Password : <input
				type="password" name="password" /> <input class="btn btn-success"
				type="submit" />
		</form>
	</div>
	<%@ include file="common/footer.jspf"%>