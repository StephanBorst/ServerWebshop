<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>forms | mvc-showcase</title>
<link href="<c:url value="/resources/form.css" />" rel="stylesheet"
	type="text/css" />

</head>
<body>

	<h2>Bestelling Pagina</h2>
	Hallo bedankt voor uw interesse in ons product! Graag dit formulier
	volledig invullen.
	<br>

	<h3>Form</h3>

	<fieldset>
		<form:form method="post" id="form" modelAttribute="Bestelling" cssClass="cleanform">
			<legend>Personal Info</legend>
			<form:label path="name">
			</form:label>
			Name <form:errors path="name" cssClass="error" />
			<form:input path="name" />
			<br>
		
			<form:label path="age">
			</form:label>
			Age <form:errors path="age" cssClass="error" />
			<form:input path="age" />

			<br>

			<input type="submit">
		</form:form>
	</fieldset>

	${Message}
</body>
</html>