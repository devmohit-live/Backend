<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Login Page</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="statics/css/login.css">
</head>
<body>
	<h2>Login Page</h2>
	<div class="container">
		<span class="error">${error}</span>
		<form method="post">
			Name : <input type="text" name="username"/>
			Password : <input type="password" name="password"/>
			<input class="btn btn-success" type="submit"/>
		</form>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"  type="text/javascript"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"  type="text/javascript"></script>
</body>
</html>