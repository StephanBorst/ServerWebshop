<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bestelling Detail View</title>
<link href="<c:url value="/resources/Detail.css" />" rel="stylesheet"
	type="text/css" />
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
</head>
<body>

	<header>
	<h2>Dit is een Overzicht van uw Bestelling</h2>
	</header>

	<div>
		<p>
			Naam: ${bestelling.name}<br> Leeftijd: ${bestelling.age}<br>
			Destination: ${bestelling.destination}<br>
		</p>
	</div>
	<c:choose>
		<c:when test="${bestelling.destination == 'Rivendel' }">
		<script>
			$(document).ready(
					function() {
						$('body').css('background-image','url(' + "../resources/Rivendel.jpg" + ')');
						$('body').css('background-size', 'cover');
					});
		</script>
		</c:when>
		<c:when test="${bestelling.destination == 'Coruscant' }">
		<script>
			$(document).ready(
					function() {
						$('body').css('background-image','url(' + "../resources/Coruscant.jpg" + ')');
						$('body').css('background-size', 'cover');
					});
		</script>
		</c:when>
		<c:when test="${bestelling.destination == 'Gotham' }">
		<script>
			$(document).ready(
					function() {
						$('body').css('background-image','url(' + "../resources/Gotham.jpg" + ')');
						$('body').css('background-size', 'cover');
					});
		</script>
		</c:when>
	</c:choose>

	<a class="button" href="http://localhost:8080/webshop">Back to
		Overview</a>

</body>
</html>