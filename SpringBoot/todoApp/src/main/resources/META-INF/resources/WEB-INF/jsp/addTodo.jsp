
	<%@ include file="common/header.jspf"%>
	<%@ include file="common/navbar.jspf"%>

	<h2>Add Todo Page</h2>
	<br>
	<br>

	<div class="container">
		<form:form method="post" modelAttribute="todo">
			<fieldset class="mb-3">
				<form:label path="description">Description</form:label>
				<form:input type="text" path="description" />
				<form:errors path="description"  cssClass="text text-danger"/>
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" />
				<form:errors path="targetDate" cssClass="text-danger" />
			</fieldset>

			<form:input type="hidden" path="isCompleted" />
			<form:input type="hidden" path="id" />

			<input type="submit" class="btn btn-success" />
		</form:form>
	</div>
	<%@ include file="common/footer.jspf"%>