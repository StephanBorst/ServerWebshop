<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>forms | mvc-showcase</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
	<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
</head>
<body>

	<h2>Bestelling Pagina</h2>
	Hallo bedankt voor uw interesse in ons product! 
	Graag dit formulier volledig invullen.
	<br>
	<form:form method="post" id="form" modelAttribute="Bestelling"
		cssClass="cleanform">
		<legend>Personal Info</legend>
		<form:label path="name">
				Name <form:errors path="name" cssClass="error" />
		</form:label>
		<form:input path="name" />
		<br>
		<form:label path="age">
				Age <form:errors path="age" cssClass="error" />
		</form:label>
		<form:input path="age" />
		<br>
		
		<input type="submit">
	</form:form>
</body>
</html>