<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bestelling Detail View</title>
<link href="<c:url value="/resources/Detail.css" />" rel="stylesheet"
	type="text/css" />
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
</head>
<body>


	<div id ="travel">
		<h3> Travel Information</h3>
		<p>ID: ${bestelling.id}<br>
			Naam: ${bestelling.name}<br> Leeftijd: ${bestelling.age}<br>
			Destination: ${bestelling.destination}<br>
			Type of trip: ${bestelling.retour}<br>
			Departure Date: <fmt:formatDate type="date" value= "${bestelling.date}" /> <br>
			<c:if test="${bestelling.retour == 'Retour'}">
			Retour Date: <fmt:formatDate type="date" value= "${bestelling.retourdate}" /> <br>
			</c:if>
			<c:choose>
			<c:when test="${bestelling.member == true}">
			Member: Yes  	 <br>
			</c:when>
			<c:when test="${bestelling.member == false}">
			Member: No     	 <br>
			</c:when>
			</c:choose>
			
		</p>
	</div>
	<div id="prijs">
		<h3> Price Information</h3>
		<p>	Price Per Unit: ${bestelling.pricePerUnit} euro<br>
			Savings: ${bestelling.savings} euro<br>
			New Price Per Unit: ${bestelling.pricePerUnit - bestelling.savings}<br>
			Number of seats: ${bestelling.seats}<br>
			Total Price: ${bestelling.priceTotal}<br>
	
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

	<a class="button" href="../overview">Back to
		Overview</a>

</body>
</html>