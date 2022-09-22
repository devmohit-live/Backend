
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<title>Todo's List Page</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h3>Welcome ${username}:</h3>
	<hr>
	<br>
	<div class="container">
		<h2>Your Todos are : </h2>
		<table class="table">
			<thead>
				<tr>
					<td>Id</td>
					<td>Description</td>
					<td>Target Date</td>
					<td>Completed</td>
				</tr>
				
			</thead>
			<tbody>
					<c:forEach items="${todos }" var="todo">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.isCompleted}</td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
		
		<a href="add-todo" class="btn btn-success" >Add Todo</a>
	</div>
	
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"  type="text/javascript"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"  type="text/javascript"></script>
</body>
</html>