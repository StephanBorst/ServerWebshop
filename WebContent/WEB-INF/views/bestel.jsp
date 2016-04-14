<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>bestel</title>
<link href="<c:url value="/resources/form.css" />" rel="stylesheet"
	type="text/css" />

</head>
<body>

	<h2>Bestelling Pagina</h2>
	Hallo bedankt voor uw interesse in ons product! Graag dit formulier
	volledig invullen.
	<br>
	<div id="formsContent">
		<h2>Forms</h2>
		
		<form:form id="form" method="post" modelAttribute="Bestelling" cssClass="cleanform">
			<div class="header">
		  		<h2>Form</h2>
		  		<c:if test="${not empty message}">
					<div id="message" class="success">${message}</div>	
		  		</c:if>
		  		<s:bind path="*">
		  			<c:if test="${status.error}">
				  		<div id="message" class="error">Form has errors</div>
		  			</c:if>
		  		</s:bind>
			</div>
	<fieldset>
		
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
	</fieldset>
		</form:form>
		</div>


</body>
</html>