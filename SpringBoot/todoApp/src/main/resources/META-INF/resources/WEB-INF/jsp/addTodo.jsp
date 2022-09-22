<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Add Todo Page</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/todoApp/src/main/resources/META-INF/resources/WEB-INF/statics/css/login.css">
</head>
<body>
	<h2>Add Todo Page</h2>
	<div class="container">
		<form:form method="post" modelAttribute="newTodo">
			Description : <form:input type="text" path="description"/>
			<form:errors path="description" cssClass="text-danger" />
			
			<br/>
			 <form:input type="hidden" path="isCompleted"/>
			 <form:input type="hidden" path="id"/>
			
			<input type="submit"  class="btn btn-success" />
		</form:form>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"  type="text/javascript"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"  type="text/javascript"></script>
</body>
</html>