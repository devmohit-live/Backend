<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Welcome Page</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@ include file="common/navbar.jspf"%>
	<div class="container-fluid">
		<p>Welcome to web ${username}</p>
		<p>Your password is ${password}</p>
		<div>
			<a href="list-todos">Manage Todos</a>
		</div>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js" type="text/javascript"></script>
</body>
</html>