
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
	
<link href="webjars/font-awesome/6.1.2/css/all.min.css"
	rel="stylesheet">
	
<title>Todo's List Page</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@ include file="common/navbar.jspf"%>
	<h3>Welcome ${username}:</h3>
	<hr>
	<br>
	<div class="container">
		<h2>Your Todos are :</h2>
		<table class="table">
			<thead>
				<tr>
					<td>Id</td>
					<td>Description</td>
					<td>Target Date</td>
					<td>Completed</td>
					<td></td>
					<td></td>
				</tr>

			</thead>
			<tbody>
				<c:forEach items="${todos }" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.isCompleted}</td>
						<td><a class="btn btn-danger"
							href="delete-todo?id=${todo.id}"><i class="fa-solid fa-trash"></i></a></td>
						<td><a class="btn btn-primary"
							href="update-todo?id=${todo.id}"><i class="fa-regular fa-pen-to-square"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a href="add-todo" class="btn btn-success">Add Todo <i class="fa-solid fa-plus"></i></a>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js" type="text/javascript"></script>
	<script src="webjars/font-awesome/6.1.2/js/all.min.js" type="text/javascript"></script>
</body>
</html>