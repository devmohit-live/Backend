<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Login Page</title>
<link rel="stylesheet" href="/todoApp/src/main/resources/META-INF/resources/WEB-INF/statics/css/login.css">
</head>
<body>
	<h2>Login Page</h2>
	<span class="error">${error}</span>
	<form method="post">
		Name : <input type="text" name="username"/>
		Password : <input type="password" name="password"/>
		<input type="submit"/>
	</form>
	
</body>
</html>