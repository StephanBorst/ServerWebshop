<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
<head>

<title>forms</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link href="<c:url value="/resources/form.css" />" rel="stylesheet"
	type="text/css" />
  
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		$(".datepicker").datepicker();
	});
</script>
<script>
	$(document).ready(function(){
	    $("#dropdown").change(function(){
	    	if($("#dropdown").val()=='Retour'){
	        $("#show").css("display","block");
	    	}else{ $("#show").css("display","none")}
	    });
	});
	</script>
</head>
<body background="resources/Sky.jpg">

	<div id="formsContent">
		<h2>Booking</h2>

		<form:form id="form" method="post" modelAttribute="Bestelling"
			cssClass="cleanform">
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
				<form:input path="name" id="name" />

				<form:label path="age">
		  			Age <form:errors path="age" cssClass="error" />
				</form:label>
				<form:input path="age" id="age" />

				<form:select path="destination" id="destiny">
					<form:option value="Rivendel">Rivendel (800 eu, excl)</form:option>
					<form:option value="Coruscant">Coruscant (1000 eu, excl)</form:option>
					<form:option value="Gotham">Gotham (300 eu, excl)</form:option>
				</form:select>
				
				
				<form:select path="retour" id="dropdown">
					<form:option value="Single" >Single Trip</form:option>
					<form:option value="Retour" >Retour Trip</form:option>
				</form:select>

				<form:label path="date">
		  			Departure Date  <form:errors path="date" cssClass="error" />
				</form:label>
				<form:input path="date" style="empty" class="datepicker" />
				
				<fieldset id="show">
				<form:label  path="retourdate">
		  			Retour Date  <form:errors path="retourdate" cssClass="error" />
				</form:label>
				<form:input  path="retourdate" style="empty" class="datepicker"/>
				</fieldset>
				
				
				<form:label path="seats">
		  			Number of seats <form:errors path="seats" cssClass="error" />
				</form:label>
				<form:input path="seats" id="seats" />


				<fieldset class="radio">
					<legend>Member? (20% off)</legend>
					<label><form:radiobutton path="member" value="true" />Yes</label>
					<label><form:radiobutton path="member" value="false" /> No</label>
				</fieldset>

			</fieldset>
			<p>
				<a class="button" style="float: left" href="../webshop">Cancel
					Order</a>
				<button type="submit" style="float: right" id="plus_btn">Submit</button>
			</p>
		</form:form>
	</div>


</body>
</html>
