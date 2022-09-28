<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Add Todo Page</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="/todoApp/src/main/resources/META-INF/resources/WEB-INF/statics/css/login.css">
<link
	href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="common/navbar.jspf"%>

	<h2>Add Todo Page</h2>
	<br>
	<br>

	<div class="container">
		<form:form method="post" modelAttribute="todo">
			<fieldset class="mb-3">
				<form:label path="description">Description</form:label>
				<form:input type="text" path="description" required="required" />
				<form:errors path="description" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" required="required" />
				<form:errors path="targetDate" cssClass="text-danger" />
			</fieldset>

			<form:input type="hidden" path="isCompleted" />
			<form:input type="hidden" path="id" />

			<input type="submit" class="btn btn-success" />
		</form:form>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js" type="text/javascript"></script>
	<script
		src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'dd-mm-yyyy',
		});
	</script>
</body>
</html>