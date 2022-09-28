	<%@ include file="common/header.jspf"%>
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
	<%@ include file="common/footer.jspf"%>
