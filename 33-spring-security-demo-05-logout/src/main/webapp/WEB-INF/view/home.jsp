<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>sjoedwards home page</title>
</head>
<body>
	<h2>sjoedwards home page</h2>
	<hr>
	<p>Test Test Test</p>

	<!-- Add a logout button -->
	<form:form
		action="${pageContext.request.contextPath}/logout"
		method="POST">
		
		<input type="submit" value="Logout">
	</form:form>
</body>

</html>