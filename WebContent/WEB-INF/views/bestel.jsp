<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>

	<title>forms</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
	
</head>
<body background = "resources/Sky.jpg">

	<div id="formsContent">
		<h2>Booking</h2>
		
		<form:form id="form" method="post" modelAttribute="Bestelling" cssClass="cleanform">
			<div class="header">
		  		<h2>Please fill in the complete form</h2>
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
		  			Name <form:errors path="name" cssClass="error" />
		 		</form:label>
		  		<form:input path="name" id ="name" />
	
		  		<form:label path="age">
		  			Age <form:errors path="age" cssClass="error"/>
		 		</form:label>
		  		<form:input path="age" id ="age"/>
		  		
		  		<form:select path= "destination" id="destiny">
				<form:option value = "Rivendel">Rivendel</form:option>
				<form:option value = "Coruscant">Coruscant</form:option>
				<form:option value = "Gotham">Gotham</form:option>
				</form:select>
				<form:select path= "retour">
				<form:option value = "Single">Single Trip</form:option>
				<form:option value = "Retour">Retour Trip</form:option>
				</form:select>
				
		  		</fieldset>
			<a class="button" href="../webshop" >Cancel Order</a>
			<a class="button" style = "float: right" href="../webshop/overview" >CheckOut</a>
			
			<p><button type="submit" style = "float: right" id="plus_btn">Submit</button>
			</p>
		</form:form>
		</div>


</body>
</html>
