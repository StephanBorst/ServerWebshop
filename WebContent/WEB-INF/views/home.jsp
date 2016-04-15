
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
<link href="<c:url value="/resources/home.css" />" rel="stylesheet"
	type="text/css" />
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
</head>
<body>
	<header>
		<h2>
			Welcome to Dream Airlines<br> Are You Ready for an Adventure?
		</h2>

	</header>

	<article>
		<p>This company provides safe and luxury travel through Space
		<hr>
		Most popular destinations
		<ol>
			<li>Middle Earth
			<li>Korhal
			<li>Coruscant
		</ol>
		<img src="resources\Spaceship.jpg">
	</article>
	<nav>
		<p>Action List
		<ul>
			<li>
				<form method="get" action="http://localhost:8080/webshop/form">
					<button type="submit">Order Ticket</button>
				</form>
			<li><a class="button"
				href="http://localhost:8080/webshop/overview">Overview Tickets</a>
		</ul>
	</nav>
	<script>
		$(document).ready(function() {
		
			var counter = 0;
		
		function ccolor(el, color) {
			
			counter++;
			if(counter % 2 ==0)
			$(el).css('color', "black");
			else
			$(el).css('color', color);
		}
		
		function makenewcolorfunction(color){
				return function() {ccolor(this, color)};
		}

		$('article').click(makenewcolorfunction("green"));
			
		});
	</script>
	<footer>
		<p>Author: Stephan Borst, Date: April 14th, 2016
	</footer>
</body>
</html>