<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<html>
<head>
<title>sjoedwards home page</title>
</head>
<body>
	<h2>sjoedwards home page</h2>
	<hr>
	<p>Test Test Test</p>
	<hr>
	<hr>
	<!-- display username and role -->

	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Role(s):
		<security:authentication property="principal.authorities" />

	</p>

	<hr>
	<!-- Add a link to point to /leaders for manager role -->
	<security:authorize access="hasRole('MANAGER')">

		<p>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip
				Meeting</a> (Only for Manager peeps)
		</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">

		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems
				Meeting</a> (Only for Admins peeps)
		</p>
	</security:authorize>




	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout">
	</form:form>
</body>

</html>